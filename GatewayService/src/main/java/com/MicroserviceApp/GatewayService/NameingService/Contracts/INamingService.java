package com.MicroserviceApp.GatewayService.NameingService.Contracts;

import com.MicroserviceApp.GatewayService.NameingService.Models.ServiceInfo;
import java.util.Optional;

public interface INamingService {

  void register(ServiceInfo serviceInfo);
  Optional<ServiceInfo> getFirstOrDefaultActuator();

}
