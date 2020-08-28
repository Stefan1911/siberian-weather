package com.MicroserviceApp.DataMicroservice.Messageing;

import com.MicroserviceApp.DataMicroservice.Context.IWeatherRepository;
import com.MicroserviceApp.DataMicroservice.DataMicroserviceApplication;
import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.TemperatureChannelProvider;
import com.MicroserviceApp.DataMicroservice.Models.DTOs.WeatherDto;
import com.MicroserviceApp.DataMicroservice.Models.DTOs.WeatherTypes;
import com.MicroserviceApp.DataMicroservice.Models.TemperatureModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(TemperatureChannelProvider.class)
public class TemperatureListener {
    private Logger logger = LoggerFactory.getLogger(DataMicroserviceApplication.class);
    @Autowired
    IWeatherRepository<TemperatureModel> temperatureRepository;

    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private AnalyticsChanelProvider analyticsChanelProvider;

    @StreamListener(TemperatureChannelProvider.INPUT)
    public void log(TemperatureModel temperatureModel) {
        logger.info("temperature has arrived :  " + temperatureModel.value);
        temperatureRepository.add(temperatureModel);
        WeatherDto weatherDto = new WeatherDto(WeatherTypes.temperature,temperatureModel.date,temperatureModel.value);
        messagingTemplate.convertAndSend("/message",weatherDto);
        analyticsChanelProvider.getChanel().send(MessageBuilder.withPayload(weatherDto).build());
    }
}
