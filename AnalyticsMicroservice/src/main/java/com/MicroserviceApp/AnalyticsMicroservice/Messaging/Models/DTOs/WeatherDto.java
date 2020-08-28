package com.MicroserviceApp.AnalyticsMicroservice.Messaging.Models.DTOs;

import java.util.Date;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Getter @Setter
public class WeatherDto {

  private WeatherTypes weatherTypes;
  private Date dateTime;
  private Integer value;


  public WeatherDto(WeatherTypes weatherTypes, Date dateTime, Integer value) {
    this.weatherTypes = weatherTypes;
    this.dateTime = dateTime;
    this.value = value;
  }
}
