package com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ServiceRegistrationSource {
  String OUTPUT = "ServiceRegistrationOutput";

  @Output(ServiceRegistrationSource.OUTPUT)
  MessageChannel output();

}
