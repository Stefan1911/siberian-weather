package com.MicroserviceApp.DeviceMicroservice.DataCollector.Sensor;

import com.MicroserviceApp.DeviceMicroservice.startup.weatherRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

@Component
public class SensorProvider {
    private HashMap<weatherRunner.WeatherAttributeType,ISensor> hashMap;

    public SensorProvider() throws IOException {
        RandomSensor randomSensor = new RandomSensor();
        this.hashMap = new HashMap<>();
        for (weatherRunner.WeatherAttributeType stat : weatherRunner.WeatherAttributeType.values()){
            this.hashMap.put(stat,new FileSensor(stat));
        }
    }

    public ISensor getSensor(weatherRunner.WeatherAttributeType stat){
        return this.hashMap.get(stat);
    }
}
