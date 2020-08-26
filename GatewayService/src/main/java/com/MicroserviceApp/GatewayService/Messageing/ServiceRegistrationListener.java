package com.MicroserviceApp.GatewayService.Messageing;

import com.MicroserviceApp.GatewayService.Messageing.ChannelProviders.ServiceRegistrationChannelProvider;
import com.MicroserviceApp.GatewayService.NameingService.Contracts.INamingService;
import com.MicroserviceApp.GatewayService.NameingService.Models.ServiceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(ServiceRegistrationChannelProvider.class)
public class ServiceRegistrationListener {

  @Autowired
  private INamingService namingService;

  @StreamListener(ServiceRegistrationChannelProvider.INPUT)
  public void log(ServiceInfo serviceInfo) {
    namingService.register(serviceInfo);
  }
}
