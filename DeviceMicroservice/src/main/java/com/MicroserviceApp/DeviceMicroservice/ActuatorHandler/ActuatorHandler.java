package com.MicroserviceApp.DeviceMicroservice.ActuatorHandler;

import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Actuators.ActuatorProvider;
import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Exceptions.UnsupportedActuatorType;
import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Models.ActuatorType;
import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Contracts.IActuator;
import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Contracts.IActuatorHandler;
import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Exceptions.InvalidCommandException;
import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Models.ActuatorInfo;
import com.MicroserviceApp.DeviceMicroservice.Models.ActuatorCommand;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ActuatorHandler implements IActuatorHandler {

  private final IActuator actuator;


  public ActuatorHandler(@Value("${actuator.type}") ActuatorType actuatorType , ActuatorProvider actuatorProvider) throws UnsupportedActuatorType {
    this.actuator = actuatorProvider.getActuator(actuatorType);
  }

  @Override
  public void executeCommand(ActuatorCommand command) throws InvalidCommandException {
    this.actuator.execute(command);
  }

  @Override
  public ActuatorInfo getActuatorSettings() {
    return this.actuator.getActuatorInfo();
  }
}
