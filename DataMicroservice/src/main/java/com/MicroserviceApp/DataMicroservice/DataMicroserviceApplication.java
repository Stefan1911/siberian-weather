package com.MicroserviceApp.DataMicroservice;

import com.MicroserviceApp.DataMicroservice.Models.TemperatureModel;
import com.MicroserviceApp.DataMicroservice.Models.WindModel;
import com.MicroserviceApp.DataMicroservice.Persitance.WeatherRepository;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.cloud.stream.messaging.Source;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class DataMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataMicroserviceApplication.class, args);

	}

}
