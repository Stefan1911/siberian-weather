package com.MicroserviceApp.GatewayService.Gateway.DTOs;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {
  private WeatherTypes weatherTypes;
  private Date dateTime;
  private Integer value;
}
