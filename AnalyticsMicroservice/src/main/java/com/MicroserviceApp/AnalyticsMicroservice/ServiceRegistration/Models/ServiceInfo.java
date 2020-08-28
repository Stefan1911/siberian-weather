package com.MicroserviceApp.AnalyticsMicroservice.ServiceRegistration.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ServiceInfo {
  private ServiceType serviceType;
  private String ipAddress;
  private int port;
}
