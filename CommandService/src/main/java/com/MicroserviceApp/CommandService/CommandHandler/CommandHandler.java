 package com.MicroserviceApp.CommandService.CommandHandler;

 import com.MicroserviceApp.CommandService.CommandHandler.Contracts.ICommandHandler;
import com.MicroserviceApp.CommandService.CommandHandler.Exceptions.NoActuatorInTheSystemException;
import com.MicroserviceApp.CommandService.CommandHandler.Messaging.ActuatorCommandChannelProvider;
import com.MicroserviceApp.CommandService.CommandHandler.Models.ActuatorInfo;
import com.MicroserviceApp.CommandService.CommandHandler.Models.Command;
import com.MicroserviceApp.CommandService.CommandHandler.Models.DTOs.ActuatorInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class CommandHandler implements ICommandHandler {

  @Autowired
  private ActuatorCommandChannelProvider channelProvider;
  @Autowired
  private RestTemplate restTemplate;
  @Value("${app.naming.endpoint}")
  private String namingEndpoint;
  @Value("${app.actuator.endpoint}")
  private String actuatorEndpoint;
  @Override
  public void handleCommand(Command command) {
    channelProvider.getChanel()
        .send(MessageBuilder.withPayload(command).build());
  }

  @Override
  public String getActuatorInfo() throws NoActuatorInTheSystemException {

    ActuatorInfoDto actuatorInfoDto = getActuatorAddress();
    return getActuatorInfoFromEndpoint(actuatorInfoDto);
  }

  private ActuatorInfoDto getActuatorAddress() throws NoActuatorInTheSystemException {
    try {
      ResponseEntity<ActuatorInfoDto> response = restTemplate.getForEntity(namingEndpoint,ActuatorInfoDto.class);
      return response.getBody();
    }
    catch (Exception exception){
      throw new NoActuatorInTheSystemException("no actuator in the system");
    }
  }

  private String getActuatorInfoFromEndpoint(ActuatorInfoDto actuatorInfoDto){
    String url = actuatorInfoDto.getFullAddress() +actuatorEndpoint;
    System.out.println(url);
    ResponseEntity<String> response = restTemplate.getForEntity(url,String.class);
    return response.getBody();
  }

}
