package com.MicroserviceApp.GatewayService.NameingService.Contracts;

import com.MicroserviceApp.GatewayService.NameingService.Models.ServiceInfo;

public interface INamingService {

  void register(ServiceInfo serviceInfo);

}
