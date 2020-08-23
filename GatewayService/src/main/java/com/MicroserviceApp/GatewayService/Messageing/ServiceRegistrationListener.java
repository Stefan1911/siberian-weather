package com.MicroserviceApp.GatewayService.Messageing;

import com.MicroserviceApp.GatewayService.GatewayServiceApplication;
import com.MicroserviceApp.GatewayService.Messageing.ChannelProviders.ServiceRegistrationChannelProvider;
import com.MicroserviceApp.GatewayService.NameingService.Contracts.INamingService;
import com.MicroserviceApp.GatewayService.NameingService.Models.ServiceInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(ServiceRegistrationChannelProvider.class)
public class ServiceRegistrationListener {

  @Autowired
  private INamingService namingService;

  private Logger logger = LoggerFactory.getLogger(GatewayServiceApplication.class);

  @StreamListener(ServiceRegistrationChannelProvider.INPUT)
  public void log(ServiceInfo serviceInfo) {
    logger.info("new service info has arrived :  " + serviceInfo.toString());
  }
}
