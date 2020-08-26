package com.MicroserviceApp.GatewayService.Messageing.ChannelProviders;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface ServiceRegistrationChannelProvider {
  String INPUT = "ServiceRegistrationInput";

  @Input(INPUT)
  MessageChannel input();
}
