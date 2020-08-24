package com.MicroserviceApp.CommandService.CommandHandler;

import com.MicroserviceApp.CommandService.CommandHandler.Contracts.ICommandHandler;
import com.MicroserviceApp.CommandService.CommandHandler.Messaging.ActuatorCommandChannelProvider;
import com.MicroserviceApp.CommandService.CommandHandler.Models.Command;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class CommandHandler implements ICommandHandler {

  @Autowired
  private ActuatorCommandChannelProvider channelProvider;

  @Override
  public void handleCommand(Command command) {
    channelProvider.getChanel()
        .send(MessageBuilder.withPayload(command).build());
  }
}
