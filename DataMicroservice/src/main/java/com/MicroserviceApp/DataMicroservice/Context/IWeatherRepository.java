package com.MicroserviceApp.DataMicroservice.Context;

import com.MicroserviceApp.DataMicroservice.Models.WeatherModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Date;
import java.util.List;

public interface IWeatherRepository<T extends WeatherModel>{
    public T add(T weather);
    public List get(int value,Class type);
    public List getByDate(Date fromDate, Date toDate,Class type);
    public List getAll(Class type);

  }
