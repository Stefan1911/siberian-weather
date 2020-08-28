package com.MicroserviceApp.AnalyticsMicroservice.Gateway.DTOs;

import com.MicroserviceApp.AnalyticsMicroservice.Messaging.Models.DTOs.WeatherTypes;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter @Setter
public class EventDTO {
  private WeatherTypes weatherTypes;
  private Date dateTime;
  private Integer value;
}
