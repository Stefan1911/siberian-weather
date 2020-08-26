package com.MicroserviceApp.CommandService.CommandHandler.Contracts;

import com.MicroserviceApp.CommandService.CommandHandler.Exceptions.NoActuatorInTheSystemException;
import com.MicroserviceApp.CommandService.CommandHandler.Models.Command;

public interface ICommandHandler {

  void handleCommand(Command command);
  String  getActuatorInfo() throws NoActuatorInTheSystemException;
}
