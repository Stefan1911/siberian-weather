package com.MicroserviceApp.AnalyticsMicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@SpringBootApplication
public class AnalyticsMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnalyticsMicroserviceApplication.class, args);
	}

	@Bean
	public RestTemplate restController(){
		return new RestTemplate();
	}

}
