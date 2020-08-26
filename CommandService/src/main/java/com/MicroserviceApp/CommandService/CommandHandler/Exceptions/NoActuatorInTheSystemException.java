package com.MicroserviceApp.CommandService.CommandHandler.Exceptions;

public class NoActuatorInTheSystemException extends Exception {

  public NoActuatorInTheSystemException(String s) {
    super(s);
  }
}
