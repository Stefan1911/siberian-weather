package com.MicroserviceApp.AnalyticsMicroservice.Gateway.Controllers;

import com.MicroserviceApp.AnalyticsMicroservice.Gateway.DTOs.EventDTO;
import com.MicroserviceApp.AnalyticsMicroservice.Messaging.Models.DTOs.WeatherDto;
import com.MicroserviceApp.AnalyticsMicroservice.Persistence.Contracts.IEventRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("event")
public class EventController {

  @Autowired
  IEventRepository eventRepository;

  @GetMapping
  public List<EventDTO> getAllEvents(){
    List<WeatherDto> weatherDTOs = eventRepository.getAll();
    return weatherDTOs.stream()
        .map(weatherDto -> {
          return EventDTO.builder()
              .dateTime(weatherDto.getDateTime())
              .value(weatherDto.getValue())
              .weatherTypes(weatherDto.getWeatherTypes())
              .build();
        })
        .collect(Collectors.toList());
  }

}
