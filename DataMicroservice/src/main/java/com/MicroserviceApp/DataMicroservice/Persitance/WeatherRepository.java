package com.MicroserviceApp.DataMicroservice.Persitance;

import com.MicroserviceApp.DataMicroservice.Context.IWeatherRepository;
import com.MicroserviceApp.DataMicroservice.Models.WeatherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Component;

import java.lang.reflect.ParameterizedType;
import java.util.Date;
import java.util.List;

@Component
public class WeatherRepository <T extends WeatherModel> implements IWeatherRepository<T> {

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public T add(T object) {
        mongoTemplate.save(object);
        return object;
    }

    public WeatherRepository() {
    }

    @Override
    public List get(Date fromDate, Date toDate) {
        return null;
    }

    @Override
    public List getAll(Class<T> type) {
      /* Query query = new Query();
        query.addCriteria(Criteria.where("salary").lt(maxSalary).gt(minSalary)); */

        return mongoTemplate.findAll(type);

    }

}
