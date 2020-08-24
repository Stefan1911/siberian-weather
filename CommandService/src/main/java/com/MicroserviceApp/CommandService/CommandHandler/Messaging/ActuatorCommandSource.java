package com.MicroserviceApp.CommandService.CommandHandler.Messaging;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ActuatorCommandSource {
  String OUTPUT = "ActuatorCommandOutput";

  @Output(ActuatorCommandSource.OUTPUT)
  MessageChannel output();

}
