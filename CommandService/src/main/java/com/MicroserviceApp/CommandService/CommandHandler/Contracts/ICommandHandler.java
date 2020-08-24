package com.MicroserviceApp.CommandService.CommandHandler.Contracts;

import com.MicroserviceApp.CommandService.CommandHandler.Models.Command;

public interface ICommandHandler {

  public void handleCommand(Command command);

}
