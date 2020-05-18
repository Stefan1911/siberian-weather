package com.MicroserviceApp.DataMicroservice.Messageing;

import com.MicroserviceApp.DataMicroservice.Context.IWeatherRepository;
import com.MicroserviceApp.DataMicroservice.DataMicroserviceApplication;
import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.PressureChannelProvider;
import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.VisibilityChannelProvider;
import com.MicroserviceApp.DataMicroservice.Models.PressureModel;
import com.MicroserviceApp.DataMicroservice.Models.VisibilityModel;
import com.MicroserviceApp.DataMicroservice.Models.WaterLevelModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;

@EnableBinding(VisibilityChannelProvider.class)
public class VisibilityListener {
    private Logger logger = LoggerFactory.getLogger(DataMicroserviceApplication.class);
    @Autowired
    IWeatherRepository<VisibilityModel>  visibilityRepository;

    @StreamListener(VisibilityChannelProvider.INPUT)
    public void log(VisibilityModel visibilityModel) {
        logger.info("visibility has arrived :  " + visibilityModel.value);
        visibilityRepository.add(visibilityModel);
    }
}
