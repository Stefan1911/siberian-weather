package com.MicroserviceApp.CommandService.CommandHandler.Models.DTOs;

import com.MicroserviceApp.CommandService.CommandHandler.Models.ActuatorType;
import com.MicroserviceApp.CommandService.ServiceRegistration.Models.ServiceType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ActuatorInfoDto {
  private ServiceType serviceType;
  private String ipAddress;
  private int port;
  private ActuatorType actuatorType;

  public String  getFullAddress(){
    return "http://" + ipAddress  + ":" + port + "/";
  }
}
