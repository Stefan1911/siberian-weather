package com.MicroserviceApp.DataMicroservice.Messageing;

import com.MicroserviceApp.DataMicroservice.Context.IWeatherRepository;
import com.MicroserviceApp.DataMicroservice.DataMicroserviceApplication;
import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.WaterLevelChannelProvider;
import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.WindChannelProvider;
import com.MicroserviceApp.DataMicroservice.Models.TemperatureModel;
import com.MicroserviceApp.DataMicroservice.Models.WaterLevelModel;
import com.MicroserviceApp.DataMicroservice.Models.WindModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@EnableBinding(WindChannelProvider.class)
public class WindListener {
    private Logger logger = LoggerFactory.getLogger(DataMicroserviceApplication.class);
    @Autowired
    IWeatherRepository<WindModel> windRepository;

    @StreamListener(WindChannelProvider.INPUT)
    public void log(WindModel windModel) {
        logger.info("wind has arrived :  " + windModel.value);
        windRepository.add(windModel);
    }
}
