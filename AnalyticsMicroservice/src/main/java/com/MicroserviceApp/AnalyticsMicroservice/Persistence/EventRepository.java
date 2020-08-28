package com.MicroserviceApp.AnalyticsMicroservice.Persistence;

import com.MicroserviceApp.AnalyticsMicroservice.Messaging.Models.DTOs.WeatherDto;
import com.MicroserviceApp.AnalyticsMicroservice.Persistence.Contracts.IEventRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

@Component
public class EventRepository implements IEventRepository {


  @Autowired
  MongoTemplate mongoTemplate;

  @Override
  public void saveEvent(WeatherDto weatherDto) {
    mongoTemplate.save(weatherDto);
  }

  @Override
  public List<WeatherDto> getAll() {
    return mongoTemplate.findAll(WeatherDto.class);
  }
}
