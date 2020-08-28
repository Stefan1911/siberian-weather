package com.MicroserviceApp.AnalyticsMicroservice.ServiceRegistration;

import com.MicroserviceApp.AnalyticsMicroservice.ServiceRegistration.Messageing.ServiceRegistrationChannelProvider;
import com.MicroserviceApp.AnalyticsMicroservice.ServiceRegistration.Models.ServiceInfo;
import com.MicroserviceApp.AnalyticsMicroservice.ServiceRegistration.Models.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class ServiceRegistration implements IServiceRegister {

  @Autowired
  private ServiceRegistrationChannelProvider serviceRegistrationChannelProvider;
  @Value("${server.port}")
  private int servicePort;
  @Value("${server.ip_address}")
  private String serviceIpAddress;

  @Override
  public void registerService(ServiceType serviceType){
    ServiceInfo serviceInfo = ServiceInfo.builder()
        .ipAddress(serviceIpAddress)
        .port(servicePort)
        .serviceType(serviceType)
        .build();

    serviceRegistrationChannelProvider.getChanel().send(MessageBuilder.withPayload(serviceInfo).build());
  }

}
