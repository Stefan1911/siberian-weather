package com.MicroserviceApp.DataMicroservice.Messageing;

import com.MicroserviceApp.DataMicroservice.Context.IWeatherRepository;
import com.MicroserviceApp.DataMicroservice.DataMicroserviceApplication;
import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.HumidityChannelProvider;
import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.PrecipitationChannelProvider;
import com.MicroserviceApp.DataMicroservice.Models.HumidityModel;
import com.MicroserviceApp.DataMicroservice.Models.PrecipitationModel;
import com.MicroserviceApp.DataMicroservice.Models.WaterLevelModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(PrecipitationChannelProvider.class)
public class PrecipitationListener {
    private Logger logger = LoggerFactory.getLogger(DataMicroserviceApplication.class);
    @Autowired
    IWeatherRepository<PrecipitationModel> precipitationRepository;

    @StreamListener(PrecipitationChannelProvider.INPUT)
    public void log(PrecipitationModel precipitationModel) throws ClassNotFoundException {
        logger.info("precipitation has arrived :  " + precipitationModel.value);
        precipitationRepository.add(precipitationModel);
    }
}
