package com.MicroserviceApp.DeviceMicroservice.Models;

import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Models.ActuatorType;
import com.MicroserviceApp.DeviceMicroservice.Models.Enumerations.ServiceType;
import com.MicroserviceApp.DeviceMicroservice.Models.Enumerations.WeatherAttributeType;
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
  private ActuatorType actuatorType;
  private WeatherAttributeType weatherAttributeType;
}
