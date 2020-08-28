package com.MicroserviceApp.GatewayService.Gateway.DTOs;

import com.MicroserviceApp.GatewayService.NameingService.Models.ServiceType;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class CommandServiceInfoDTO {
  private ServiceType serviceType;
  private String ipAddress;
  private int port;
}
