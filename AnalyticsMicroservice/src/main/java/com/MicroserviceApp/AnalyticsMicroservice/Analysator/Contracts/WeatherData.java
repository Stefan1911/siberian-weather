package com.MicroserviceApp.AnalyticsMicroservice.Analysator.Contracts;

import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class WeatherData {
  private final Date dateTime;
  private final Integer value;
}
