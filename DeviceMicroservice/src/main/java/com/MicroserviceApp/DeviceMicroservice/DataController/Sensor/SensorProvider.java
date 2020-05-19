package com.MicroserviceApp.DeviceMicroservice.DataController.Sensor;

import com.MicroserviceApp.DeviceMicroservice.DataController.Sensor.ISensor;
import com.MicroserviceApp.DeviceMicroservice.DataController.Sensor.RandomSensor;
import com.MicroserviceApp.DeviceMicroservice.startup.weatherRunner;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;

@Component
public class SensorProvider {
    private HashMap<weatherRunner.WeatherStats,ISensor> hashMap;

    public SensorProvider() throws IOException {
        RandomSensor randomSensor = new RandomSensor();
        this.hashMap = new HashMap<>();
        for (weatherRunner.WeatherStats stat : weatherRunner.WeatherStats.values()){
            this.hashMap.put(stat,new FileSensor(stat));
        }
//        this.hashMap.put(weatherRunner.WeatherStats.TEMPERATURE,new FileSensor(weatherRunner.WeatherStats.TEMPERATURE));
//        this.hashMap.put(weatherRunner.WeatherStats.WIND,new FileSensor(weatherRunner.WeatherStats.WIND));
    }

    public ISensor getSensor(weatherRunner.WeatherStats stat){
        return this.hashMap.get(stat);
    }
}
