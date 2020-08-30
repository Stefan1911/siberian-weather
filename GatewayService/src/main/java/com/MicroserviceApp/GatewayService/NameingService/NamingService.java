package com.MicroserviceApp.GatewayService.NameingService;

import com.MicroserviceApp.GatewayService.Gateway.DTOs.Command;
import com.MicroserviceApp.GatewayService.Gateway.DTOs.EventDTO;
import com.MicroserviceApp.GatewayService.NameingService.Contracts.INamingService;
import com.MicroserviceApp.GatewayService.NameingService.Models.ServiceInfo;
import com.MicroserviceApp.GatewayService.NameingService.Models.ServiceType;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NamingService implements INamingService {

  @Getter
  private Map<ServiceType, Set<ServiceInfo>> serviceInfoMap;
  @Autowired
  private RestTemplate restTemplate;

  public NamingService() {
    this.serviceInfoMap = new HashMap<>();
    for(ServiceType serviceType : ServiceType.values()){
      serviceInfoMap.put(serviceType,new HashSet<>());
    }
  }

  @Override
  public void register(ServiceInfo serviceInfo) {
    serviceInfoMap.get(serviceInfo.getServiceType()).add(serviceInfo);
  }

  @Override
  public Optional<ServiceInfo> getFirstOrDefaultActuator() {
    Iterator<ServiceInfo> serviceInfoIterator = serviceInfoMap.get(ServiceType.ACTUATOR_SERVICE)
        .iterator();
    return serviceInfoIterator.hasNext() ? Optional.of(serviceInfoIterator.next()) : Optional.empty() ;
  }

  @Override
  public Map<ServiceType, Set<ServiceInfo>> getAllServices() {
    return serviceInfoMap;
  }

  @Override
  public void removeFromRegistry(ServiceInfo serviceInfo) {
    serviceInfoMap.get(serviceInfo.getServiceType()).remove(serviceInfo);
  }

  @Override
  public Optional<ServiceInfo> getCommandService() {
    Iterator<ServiceInfo> serviceInfoIterator = serviceInfoMap.get(ServiceType.COMMAND_SERVICE)
        .iterator();
    return serviceInfoIterator.hasNext() ? Optional.of(serviceInfoIterator.next()) : Optional.empty() ;
  }

  @Override
  public ResponseEntity<EventDTO[]> getAllEvents() {
    Iterator<ServiceInfo> serviceInfoIterator = serviceInfoMap.get(ServiceType.ANALYTICS_SERVICE)
        .iterator();
    if(serviceInfoIterator.hasNext()){
      ServiceInfo analyticsServiceInfo = serviceInfoIterator.next();
      return restTemplate.getForEntity(analyticsServiceInfo.getFullAddress()+"event",EventDTO[].class);
    }
    else {
       return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }



  }

  @Override
  public String getAllCommands() {
    Iterator<ServiceInfo> serviceInfoIterator = serviceInfoMap.get(ServiceType.COMMAND_SERVICE)
        .iterator();
    if(serviceInfoIterator.hasNext()){
      ServiceInfo commandServiceInfo = serviceInfoIterator.next();
      return restTemplate
          .getForEntity(commandServiceInfo.getFullAddress()+"command", String.class)
          .getBody();
    }
    else {
      return null;
    }

  }

  @Override
  public void executeCommand(Command command) {
    Iterator<ServiceInfo> serviceInfoIterator = serviceInfoMap.get(ServiceType.COMMAND_SERVICE)
        .iterator();
    ServiceInfo commandServiceInfo = serviceInfoIterator.next();
    restTemplate
        .postForLocation(commandServiceInfo.getFullAddress()+"command", command);
  }

}
