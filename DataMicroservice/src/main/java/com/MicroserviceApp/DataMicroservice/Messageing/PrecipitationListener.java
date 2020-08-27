package com.MicroserviceApp.DataMicroservice.Messageing;

import com.MicroserviceApp.DataMicroservice.Context.IWeatherRepository;
import com.MicroserviceApp.DataMicroservice.DataMicroserviceApplication;
import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.HumidityChannelProvider;
import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.PrecipitationChannelProvider;
import com.MicroserviceApp.DataMicroservice.Models.DTOs.WeatherDto;
import com.MicroserviceApp.DataMicroservice.Models.DTOs.WeatherTypes;
import com.MicroserviceApp.DataMicroservice.Models.HumidityModel;
import com.MicroserviceApp.DataMicroservice.Models.PrecipitationModel;
import com.MicroserviceApp.DataMicroservice.Models.WaterLevelModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;

@EnableBinding(PrecipitationChannelProvider.class)
public class PrecipitationListener {
    private Logger logger = LoggerFactory.getLogger(DataMicroserviceApplication.class);
    @Autowired
    IWeatherRepository<PrecipitationModel> precipitationRepository;
    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    @StreamListener(PrecipitationChannelProvider.INPUT)
    public void log(PrecipitationModel precipitationModel) {
        logger.info("precipitation has arrived :  " + precipitationModel.value);
        precipitationRepository.add(precipitationModel);
        messagingTemplate.convertAndSend("/message",new WeatherDto(WeatherTypes.precipitation,precipitationModel.date,precipitationModel.value));
    }
}
