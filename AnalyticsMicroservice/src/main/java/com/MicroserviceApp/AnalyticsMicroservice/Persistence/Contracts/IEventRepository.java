package com.MicroserviceApp.AnalyticsMicroservice.Persistence.Contracts;

import com.MicroserviceApp.AnalyticsMicroservice.Messaging.Models.DTOs.WeatherDto;
import java.util.List;

public interface IEventRepository {
  void saveEvent(WeatherDto weatherDto);
  List<WeatherDto> getAll();
}
