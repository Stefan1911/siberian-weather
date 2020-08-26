package com.MicroserviceApp.DataMicroservice.Messageing;

import com.MicroserviceApp.DataMicroservice.Context.IWeatherRepository;
import com.MicroserviceApp.DataMicroservice.DataMicroserviceApplication;
import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.HumidityChannelProvider;
import com.MicroserviceApp.DataMicroservice.Models.HumidityModel;
import com.MicroserviceApp.DataMicroservice.Models.WaterLevelModel;
import com.MicroserviceApp.DataMicroservice.Persitance.WeatherRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(HumidityChannelProvider.class)
public class HumidityListener {
        private Logger logger = LoggerFactory.getLogger(DataMicroserviceApplication.class);
        @Autowired
        IWeatherRepository<HumidityModel> humidityRepository;

        @StreamListener(HumidityChannelProvider.INPUT)
        public void log(HumidityModel humidityModel) throws ClassNotFoundException {
            logger.info("humidity has arrived :  " + humidityModel.value);
            humidityRepository.add(humidityModel);
        }
}
