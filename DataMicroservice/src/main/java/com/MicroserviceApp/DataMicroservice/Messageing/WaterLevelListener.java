package com.MicroserviceApp.DataMicroservice.Messageing;

import com.MicroserviceApp.DataMicroservice.Context.IWeatherRepository;
import com.MicroserviceApp.DataMicroservice.DataMicroserviceApplication;
import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.VisibilityChannelProvider;
import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.WaterLevelChannelProvider;
import com.MicroserviceApp.DataMicroservice.Models.TemperatureModel;
import com.MicroserviceApp.DataMicroservice.Models.VisibilityModel;
import com.MicroserviceApp.DataMicroservice.Models.WaterLevelModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(WaterLevelChannelProvider.class)
public class WaterLevelListener {
    private Logger logger = LoggerFactory.getLogger(DataMicroserviceApplication.class);
    @Autowired
    IWeatherRepository<WaterLevelModel> waterLevelRepository;

    @StreamListener(WaterLevelChannelProvider.INPUT)
    public void log(WaterLevelModel waterLevelModel) {
        logger.info("WaterLevel has arrived :  " + waterLevelModel.value);
        waterLevelRepository.add(waterLevelModel);
    }
}
