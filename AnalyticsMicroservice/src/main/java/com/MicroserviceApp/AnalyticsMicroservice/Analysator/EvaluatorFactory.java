package com.MicroserviceApp.AnalyticsMicroservice.Analysator;


import com.MicroserviceApp.AnalyticsMicroservice.Analysator.Contracts.IWeatherEvaluator;
import com.MicroserviceApp.AnalyticsMicroservice.Messaging.Models.DTOs.WeatherTypes;
import org.springframework.stereotype.Component;


@Component
public class EvaluatorFactory {
  public IWeatherEvaluator getEvaluator(WeatherTypes weatherTypes){
    switch (weatherTypes){
      default: return new RandomWeatherEvaluator();
    }
  }

}
