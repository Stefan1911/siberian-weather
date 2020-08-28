package com.MicroserviceApp.AnalyticsMicroservice.Messaging;

import com.MicroserviceApp.AnalyticsMicroservice.Analysator.Contracts.WeatherData;
import com.MicroserviceApp.AnalyticsMicroservice.Analysator.EvaluatorFactory;
import com.MicroserviceApp.AnalyticsMicroservice.Messaging.Models.DTOs.WeatherDto;
import com.MicroserviceApp.AnalyticsMicroservice.Messaging.Source.AnalyticsSource;
import com.MicroserviceApp.AnalyticsMicroservice.Persistence.Contracts.IEventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(AnalyticsSource.class)
public class AnalyticsListener {

  @Autowired
  private EvaluatorFactory evaluatorFactory;
  @Autowired
  private IEventRepository eventRepository;

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

  }

  private void executeActuator() {

  }

  private void saveToDatabase(WeatherDto weatherDto){
    eventRepository.saveEvent(weatherDto);
  }

}
