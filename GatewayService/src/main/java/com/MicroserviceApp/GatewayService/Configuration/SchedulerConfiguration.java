package com.MicroserviceApp.GatewayService.Configuration;

import com.MicroserviceApp.GatewayService.NameingService.Contracts.INamingService;
import com.MicroserviceApp.GatewayService.NameingService.Models.ServiceInfo;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableScheduling
public class SchedulerConfiguration {

  @Autowired
  private INamingService namingService;
  @Autowired
  private RestTemplate restTemplate;

  @Scheduled(fixedDelay = 5000)
  public void scheduleFixedDelayTask() {

    Set<ServiceInfo> allServices = namingService.getAllServices().values()
        .stream()
        .flatMap(Set::stream)
        .collect(Collectors.toSet());
    Iterator<ServiceInfo> serviceInfoIterator = allServices.iterator();

    while (serviceInfoIterator.hasNext()){
      ServiceInfo serviceInfo = serviceInfoIterator.next();
      try {
        ResponseEntity<String> response = restTemplate.getForEntity(serviceInfo.getFullAddress()+"ping", String.class);
      }catch (Exception exception){
          removeFromRegistry(serviceInfo);
      }

    }



    System.out.println(
        "Fixed delay task - " + allServices.toString());
  }

  private void removeFromRegistry(ServiceInfo serviceInfo) {
    this.namingService.removeFromRegistry(serviceInfo);
  }
}
