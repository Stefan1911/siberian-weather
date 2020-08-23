package com.MicroserviceApp.CommandService.Startup;

import com.MicroserviceApp.CommandService.Messageing.ChannelProviders.ServiceRegistrationChannelProvider;
import com.MicroserviceApp.CommandService.Models.ServiceInfo;
import com.MicroserviceApp.CommandService.Models.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ServiceRegistration {

  @Autowired
  private ServiceRegistrationChannelProvider serviceRegistrationChannelProvider;
  @Value("${server.port}")
  private int servicePort;
  @Value("${server.ip_address}")
  private String serviceIpAddress;


  public void registerService(ServiceType serviceType){
    ServiceInfo serviceInfo = ServiceInfo.builder()
        .ipAddress(serviceIpAddress)
        .port(servicePort)
        .serviceType(serviceType)
        .build();

    serviceRegistrationChannelProvider.getChanel().send(MessageBuilder.withPayload(serviceInfo).build());
  }

}
