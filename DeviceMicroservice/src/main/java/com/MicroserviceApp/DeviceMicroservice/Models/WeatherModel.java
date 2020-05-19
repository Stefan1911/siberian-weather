package com.MicroserviceApp.DeviceMicroservice.Models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WeatherModel {
    private Date date;
    private double value;

    public WeatherModel(double value,Date date) {
        this.date = date;
        this.value = value;
    }
}
