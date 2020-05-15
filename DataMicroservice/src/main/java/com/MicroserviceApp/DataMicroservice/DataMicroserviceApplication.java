package com.MicroserviceApp.DataMicroservice;

import com.MicroserviceApp.DataMicroservice.Models.WindModel;
import com.MicroserviceApp.DataMicroservice.Persitance.WeatherRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DataMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataMicroserviceApplication.class, args);

	}

}
