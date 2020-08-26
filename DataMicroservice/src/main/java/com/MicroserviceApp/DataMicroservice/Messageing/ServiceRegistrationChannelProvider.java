package com.MicroserviceApp.DataMicroservice.Messageing;

import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.ServiceRegistrationSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(ServiceRegistrationSource.class)
public class ServiceRegistrationChannelProvider {
  @Autowired
  private MessageChannel ServiceRegistrationOutput;

  public MessageChannel getChanel() {
    return ServiceRegistrationOutput;
  }
}
