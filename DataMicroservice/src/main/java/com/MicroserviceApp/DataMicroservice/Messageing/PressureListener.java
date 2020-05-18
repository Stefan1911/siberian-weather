package com.MicroserviceApp.DataMicroservice.Messageing;


import com.MicroserviceApp.DataMicroservice.Context.IWeatherRepository;
import com.MicroserviceApp.DataMicroservice.DataMicroserviceApplication;
import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.PrecipitationChannelProvider;
import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.PressureChannelProvider;
import com.MicroserviceApp.DataMicroservice.Models.PrecipitationModel;
import com.MicroserviceApp.DataMicroservice.Models.PressureModel;
import com.MicroserviceApp.DataMicroservice.Models.WaterLevelModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(PressureChannelProvider.class)
public class PressureListener {
    private Logger logger = LoggerFactory.getLogger(DataMicroserviceApplication.class);
    @Autowired
    IWeatherRepository<PressureModel> pressureRepository;

    @StreamListener(PressureChannelProvider.INPUT)
    public void log(PressureModel pressureModel) {
        pressureRepository.add(pressureModel);
        logger.info("pressure has arrived :  " + pressureModel.value);
    }
}
