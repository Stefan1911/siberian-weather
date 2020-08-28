package com.MicroserviceApp.GatewayService.NameingService.Models;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ServiceInfo {
  private ServiceType serviceType;
  private String ipAddress;
  private int port;
  private ActuatorType actuatorType;
  private WeatherAttributeType weatherAttributeType;

  public String  getFullAddress(){
    return "http://" + ipAddress  + ":" + port + "/";
  }
}
