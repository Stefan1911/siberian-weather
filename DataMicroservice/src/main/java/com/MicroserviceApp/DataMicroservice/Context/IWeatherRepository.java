package com.MicroserviceApp.DataMicroservice.Context;

import com.MicroserviceApp.DataMicroservice.Models.WeatherModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

import java.util.Date;
import java.util.List;

public interface IWeatherRepository<T> {
    public T add(T object);
    public List<T> get(int value,Class<T> type);
    public List getAll(Class<T> type);

  /*extends MongoRepository<T, String>, QuerydslPredicateExecutor<T> */
}
