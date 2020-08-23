package com.MicroserviceApp.DeviceMicroservice.Messageing.ChannelProvider;

import com.MicroserviceApp.DeviceMicroservice.Messageing.IChannelProvider;
import com.MicroserviceApp.DeviceMicroservice.Messageing.WeatehrSource.ServiceRegistrationSource;
import com.MicroserviceApp.DeviceMicroservice.Messageing.WeatehrSource.VisibilitySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(ServiceRegistrationSource.class)
public class ServiceRegistrationChannelProvider implements IChannelProvider {
  @Autowired
  private MessageChannel ServiceRegistrationOutput;

  @Override
  public MessageChannel getChanel() {
    return ServiceRegistrationOutput;
  }
}
