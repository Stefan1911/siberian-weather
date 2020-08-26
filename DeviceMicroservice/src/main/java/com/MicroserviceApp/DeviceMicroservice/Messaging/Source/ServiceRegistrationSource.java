package com.MicroserviceApp.DeviceMicroservice.Messaging.Source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ServiceRegistrationSource {
  String OUTPUT = "ServiceRegistrationOutput";

  @Output(ServiceRegistrationSource.OUTPUT)
  MessageChannel output();

}
