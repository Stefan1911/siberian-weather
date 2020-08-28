package com.MicroserviceApp.DataMicroservice.Messageing;

import com.MicroserviceApp.DataMicroservice.Context.IWeatherRepository;
import com.MicroserviceApp.DataMicroservice.DataMicroserviceApplication;
import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.HumidityChannelProvider;
import com.MicroserviceApp.DataMicroservice.Models.DTOs.WeatherDto;
import com.MicroserviceApp.DataMicroservice.Models.DTOs.WeatherTypes;
import com.MicroserviceApp.DataMicroservice.Models.HumidityModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.messaging.support.MessageBuilder;

@EnableBinding(HumidityChannelProvider.class)
public class HumidityListener {
        private Logger logger = LoggerFactory.getLogger(DataMicroserviceApplication.class);
        @Autowired
        private IWeatherRepository<HumidityModel> humidityRepository;
        @Autowired
        private AnalyticsChanelProvider analyticsChanelProvider;
        @Autowired
        private SimpMessagingTemplate messagingTemplate;
        @StreamListener(HumidityChannelProvider.INPUT)
        public void log(HumidityModel humidityModel) {
          logger.info("humidity has arrived :  " + humidityModel.value);
          humidityRepository.add(humidityModel);
          WeatherDto weatherDto = new WeatherDto(WeatherTypes.humidity,humidityModel.date,humidityModel.value);
          messagingTemplate.convertAndSend("/message",weatherDto);
          analyticsChanelProvider.getChanel().send(MessageBuilder.withPayload(weatherDto).build());
        }
}
