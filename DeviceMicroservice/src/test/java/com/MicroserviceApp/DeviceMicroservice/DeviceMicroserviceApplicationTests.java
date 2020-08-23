package com.MicroserviceApp.DeviceMicroservice;

import com.MicroserviceApp.DeviceMicroservice.DataCollector.Sensor.FileSensor;
import com.MicroserviceApp.DeviceMicroservice.Models.Enumerations.WeatherAttributeType;
import com.MicroserviceApp.DeviceMicroservice.startup.weatherRunner;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class DeviceMicroserviceApplicationTests {

	@Test
	void contextLoads() throws IOException, ParseException {
		FileSensor fileSensor = new FileSensor(WeatherAttributeType.WIND);
		Double firstValue = fileSensor.nextValue();
		Double secondValue = fileSensor.nextValue();
		assertNotNull(firstValue);
		assertNotNull(secondValue);
	}

}
