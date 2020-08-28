package com.MicroserviceApp.AnalyticsMicroservice.Messaging.Models.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommandServiceInfoDTO {
  private ServiceType serviceType;
  private String ipAddress;
  private int port;

  public String  getFullAddress(){
    return "http://" + ipAddress  + ":" + port + "/";
  }
}
