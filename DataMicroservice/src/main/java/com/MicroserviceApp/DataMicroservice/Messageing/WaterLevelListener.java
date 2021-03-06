package com.MicroserviceApp.DataMicroservice.Messageing;

import com.MicroserviceApp.DataMicroservice.Context.IWeatherRepository;
import com.MicroserviceApp.DataMicroservice.DataMicroserviceApplication;
import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.WaterLevelChannelProvider;
import com.MicroserviceApp.DataMicroservice.Models.DTOs.WeatherDto;
import com.MicroserviceApp.DataMicroservice.Models.DTOs.WeatherTypes;
import com.MicroserviceApp.DataMicroservice.Models.WaterLevelModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(WaterLevelChannelProvider.class)
public class WaterLevelListener {
    private Logger logger = LoggerFactory.getLogger(DataMicroserviceApplication.class);
    @Autowired
    IWeatherRepository<WaterLevelModel> waterLevelRepository;
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private AnalyticsChanelProvider analyticsChanelProvider;

    @StreamListener(WaterLevelChannelProvider.INPUT)
    public void log(WaterLevelModel waterLevelModel) {
        logger.info("WaterLevel has arrived :  " + waterLevelModel.value);
        waterLevelRepository.add(waterLevelModel);
        WeatherDto weatherDto =new WeatherDto(WeatherTypes.waterLevel,waterLevelModel.date,waterLevelModel.value);
        messagingTemplate.convertAndSend("/message",weatherDto);
        analyticsChanelProvider.getChanel().send(MessageBuilder.withPayload(weatherDto).build());
    }
}
