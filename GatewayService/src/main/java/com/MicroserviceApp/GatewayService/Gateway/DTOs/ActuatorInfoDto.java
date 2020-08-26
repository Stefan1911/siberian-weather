package com.MicroserviceApp.GatewayService.Gateway.DTOs;

import com.MicroserviceApp.GatewayService.NameingService.Models.ActuatorType;
import com.MicroserviceApp.GatewayService.NameingService.Models.ServiceType;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ActuatorInfoDto {
  private ServiceType serviceType;
  private String ipAddress;
  private int port;
  private ActuatorType actuatorType;
}
