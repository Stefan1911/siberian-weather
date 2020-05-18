package com.MicroserviceApp.DataMicroservice.Persitance;

import com.MicroserviceApp.DataMicroservice.Context.IWeatherRepository;
import com.MicroserviceApp.DataMicroservice.Models.WeatherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

@Component
public class WeatherRepository <T extends WeatherModel> implements IWeatherRepository<T> {

    @Autowired
    MongoTemplate mongoTemplate;

    public WeatherRepository() {
    }

    @Override
    public T add(T object) {
        mongoTemplate.save(object);
        return object;
    }

    @Override
    public List<T> get(int value , Class<T> type) {
        BasicQuery query1 = new BasicQuery("{ 'value': "+value+" }");
        return mongoTemplate.find(query1,type);
    }

    @Override
    public List getAll(Class<T> type) {
        return mongoTemplate.findAll(type);
    }

}
