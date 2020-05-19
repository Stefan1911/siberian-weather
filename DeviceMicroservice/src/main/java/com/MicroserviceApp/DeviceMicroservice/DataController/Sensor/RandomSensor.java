package com.MicroserviceApp.DeviceMicroservice.DataController.Sensor;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomSensor implements ISensor {

    Random random = new Random();
    @Override
    public Double nextValue() {
        return this.random.nextDouble();
    }
}
