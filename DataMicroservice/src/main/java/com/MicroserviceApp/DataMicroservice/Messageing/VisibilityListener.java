package com.MicroserviceApp.DataMicroservice.Messageing;

import com.MicroserviceApp.DataMicroservice.Context.IWeatherRepository;
import com.MicroserviceApp.DataMicroservice.DataMicroserviceApplication;
import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.VisibilityChannelProvider;
import com.MicroserviceApp.DataMicroservice.Models.DTOs.WeatherDto;
import com.MicroserviceApp.DataMicroservice.Models.DTOs.WeatherTypes;
import com.MicroserviceApp.DataMicroservice.Models.VisibilityModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(VisibilityChannelProvider.class)
public class VisibilityListener {
    private Logger logger = LoggerFactory.getLogger(DataMicroserviceApplication.class);
    @Autowired
    IWeatherRepository<VisibilityModel>  visibilityRepository;
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private AnalyticsChanelProvider analyticsChanelProvider;

    @StreamListener(VisibilityChannelProvider.INPUT)
    public void log(VisibilityModel visibilityModel) {
        logger.info("visibility has arrived :  " + visibilityModel.value);
        visibilityRepository.add(visibilityModel);
        WeatherDto weatherDto = new WeatherDto(WeatherTypes.visibility,visibilityModel.date,visibilityModel.value);
        messagingTemplate.convertAndSend("/message",weatherDto);
        analyticsChanelProvider.getChanel().send(MessageBuilder.withPayload(weatherDto).build());
    }
}
