package com.MicroserviceApp.DataMicroservice.Messageing;

import com.MicroserviceApp.DataMicroservice.Context.IWeatherRepository;
import com.MicroserviceApp.DataMicroservice.DataMicroserviceApplication;
import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.TemperatureChannelProvider;
import com.MicroserviceApp.DataMicroservice.Models.DTOs.WeatherDto;
import com.MicroserviceApp.DataMicroservice.Models.DTOs.WeatherTypes;
import com.MicroserviceApp.DataMicroservice.Models.HumidityModel;
import com.MicroserviceApp.DataMicroservice.Models.TemperatureModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@EnableBinding(TemperatureChannelProvider.class)
public class TemperatureListener {
    private Logger logger = LoggerFactory.getLogger(DataMicroserviceApplication.class);
    @Autowired
    IWeatherRepository<TemperatureModel> temperatureRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @StreamListener(TemperatureChannelProvider.INPUT)
    public void log(TemperatureModel temperatureModel) {
        logger.info("temperature has arrived :  " + temperatureModel.value);
        temperatureRepository.add(temperatureModel);
        messagingTemplate.convertAndSend("/message",new WeatherDto(WeatherTypes.temperature,temperatureModel.date,temperatureModel.value));
    }
}
