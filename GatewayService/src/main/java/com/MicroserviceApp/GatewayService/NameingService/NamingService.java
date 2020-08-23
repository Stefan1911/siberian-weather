package com.MicroserviceApp.GatewayService.NameingService;

import com.MicroserviceApp.GatewayService.NameingService.Contracts.INamingService;
import com.MicroserviceApp.GatewayService.NameingService.Models.ServiceInfo;
import com.MicroserviceApp.GatewayService.NameingService.Models.ServiceType;
import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service
public class NamingService implements INamingService {

  @Getter
  private Map<ServiceType,ServiceInfo> serviceInfoMap;

  public NamingService() {
    this.serviceInfoMap = new HashMap<>();
  }

  @Override
  public void register(ServiceInfo serviceInfo) {
    serviceInfoMap.put(serviceInfo.getServiceType(),serviceInfo);
    System.out.println("Service registered :"+ serviceInfo.toString());
  }
}
