package com.MicroserviceApp.AnalyticsMicroservice.Messaging;

import com.MicroserviceApp.AnalyticsMicroservice.Analysator.Contracts.WeatherData;
import com.MicroserviceApp.AnalyticsMicroservice.Analysator.EvaluatorFactory;
import com.MicroserviceApp.AnalyticsMicroservice.Gateway.DTOs.EventDTO;
import com.MicroserviceApp.AnalyticsMicroservice.Messaging.Models.Command;
import com.MicroserviceApp.AnalyticsMicroservice.Messaging.Models.DTOs.CommandServiceInfoDTO;
import com.MicroserviceApp.AnalyticsMicroservice.Messaging.Models.DTOs.WeatherDto;
import com.MicroserviceApp.AnalyticsMicroservice.Messaging.Source.AnalyticsSource;
import com.MicroserviceApp.AnalyticsMicroservice.Persistence.Contracts.IEventRepository;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.client.RestTemplate;


@EnableBinding(AnalyticsSource.class)
public class AnalyticsListener {

  @Autowired
  private EvaluatorFactory evaluatorFactory;
  @Autowired
  private IEventRepository eventRepository;
  @Autowired
  private RestTemplate restTemplate;
  @Value("${app.naming.endpoint}")
  private String namingEndpoint;
  @Value("${app.command.endpoint}")
  private String actuatorEndpoint;
  @Autowired
  private SimpMessagingTemplate messagingTemplate;

  @StreamListener(AnalyticsSource.INPUT)
  public void log(WeatherDto weatherDto) {
    boolean isUnusualValue = evaluatorFactory.getEvaluator(weatherDto.getWeatherTypes())
        .evaluate(new WeatherData(weatherDto.getDateTime(),weatherDto.getValue()));
    if(isUnusualValue){
      saveToDatabase(weatherDto);
      executeActuator();
      sendToDashboard(weatherDto);
    }
    System.out.println("isUnusualValue: " + isUnusualValue);
  }

  private void sendToDashboard(WeatherDto weatherDto) {
    EventDTO eventDTO = EventDTO.builder()
        .dateTime(weatherDto.getDateTime())
        .value(weatherDto.getValue())
        .weatherTypes(weatherDto.getWeatherTypes())
        .build();
    messagingTemplate.convertAndSend("/message",eventDTO);
  }

  private void executeActuator() {
    try {
      ResponseEntity<CommandServiceInfoDTO> response = restTemplate.getForEntity(namingEndpoint, CommandServiceInfoDTO.class);
      Command commandRequest = Command.builder()
          .commandName("alarm")
          .commandParameters(Arrays.asList("10"))
          .build();
      restTemplate.postForLocation(response.getBody().getFullAddress() + actuatorEndpoint,commandRequest);
    }catch (Exception exception) {
      System.out.println("an error occurred while send a command" + exception.getMessage());
    }
  }

  private void saveToDatabase(WeatherDto weatherDto){
    eventRepository.saveEvent(weatherDto);
  }

}
