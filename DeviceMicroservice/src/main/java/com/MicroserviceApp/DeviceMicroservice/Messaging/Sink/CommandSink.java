package com.MicroserviceApp.DeviceMicroservice.Messaging.Sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface CommandSink {
  String INPUT = "CommandInput";

  @Input(INPUT)
  MessageChannel input();
}
