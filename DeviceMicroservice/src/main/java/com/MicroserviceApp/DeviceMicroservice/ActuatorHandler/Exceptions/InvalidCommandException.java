package com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Exceptions;

import com.MicroserviceApp.DeviceMicroservice.Models.ActuatorCommand;

public class InvalidCommandException extends Exception {

  public InvalidCommandException(ActuatorCommand command) {
    super("the comand :" + command + "was invalid");
  }
}
