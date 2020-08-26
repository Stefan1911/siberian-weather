package com.MicroserviceApp.CommandService.CommandHandler.Messaging;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(ActuatorCommandSource.class)
public class ActuatorCommandChannelProvider {
  @Autowired
  private MessageChannel ActuatorCommandOutput;

  public MessageChannel getChanel() {
    return ActuatorCommandOutput;
  }
}
