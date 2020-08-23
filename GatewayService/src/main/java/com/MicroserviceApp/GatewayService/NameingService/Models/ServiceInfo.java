package com.MicroserviceApp.GatewayService.NameingService.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ServiceInfo {
  private ServiceType serviceType;
  private String ipAddress;
  private int port;

  private ActuatorType actuatorType;
}
