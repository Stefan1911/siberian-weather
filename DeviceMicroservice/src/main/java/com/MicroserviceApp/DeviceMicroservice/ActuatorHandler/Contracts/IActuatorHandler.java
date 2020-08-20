package com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Contracts;

import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Exceptions.InvalidCommandException;
import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Models.ActuatorInfo;
import com.MicroserviceApp.DeviceMicroservice.Models.ActuatorCommand;

public interface IActuatorHandler {

  void executeCommand(ActuatorCommand command) throws InvalidCommandException;
  ActuatorInfo getActuatorSettings();

}
