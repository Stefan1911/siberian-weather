package com.MicroserviceApp.DataMicroservice.Messageing;

import com.MicroserviceApp.DataMicroservice.Context.IWeatherRepository;
import com.MicroserviceApp.DataMicroservice.DataMicroserviceApplication;
import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.WindChannelProvider;
import com.MicroserviceApp.DataMicroservice.Models.DTOs.WeatherDto;
import com.MicroserviceApp.DataMicroservice.Models.DTOs.WeatherTypes;
import com.MicroserviceApp.DataMicroservice.Models.WindModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(WindChannelProvider.class)
public class WindListener {
    private Logger logger = LoggerFactory.getLogger(DataMicroserviceApplication.class);
    @Autowired
    IWeatherRepository<WindModel> windRepository;
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @Autowired
    private AnalyticsChanelProvider analyticsChanelProvider;

    @StreamListener(WindChannelProvider.INPUT)
    public void log(WindModel windModel) {
        logger.info("wind has arrived :  " + windModel.value);
        windRepository.add(windModel);
        WeatherDto weatherDto = new WeatherDto(WeatherTypes.wind,windModel.date,windModel.value);
        messagingTemplate.convertAndSend("/message",weatherDto);
        analyticsChanelProvider.getChanel().send(MessageBuilder.withPayload(weatherDto).build());
    }
}
