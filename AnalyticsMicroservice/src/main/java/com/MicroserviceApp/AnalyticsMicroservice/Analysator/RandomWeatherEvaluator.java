package com.MicroserviceApp.AnalyticsMicroservice.Analysator;

import com.MicroserviceApp.AnalyticsMicroservice.Analysator.Contracts.IWeatherEvaluator;
import com.MicroserviceApp.AnalyticsMicroservice.Analysator.Contracts.WeatherData;

public class RandomWeatherEvaluator implements IWeatherEvaluator {

  @Override
  public boolean evaluate(WeatherData weatherData){
      return Math.random() < 0.05;
  }
}
