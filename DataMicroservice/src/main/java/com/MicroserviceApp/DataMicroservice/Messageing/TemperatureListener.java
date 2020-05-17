package com.MicroserviceApp.DataMicroservice.Messageing;

import com.MicroserviceApp.DataMicroservice.DataMicroserviceApplication;
import com.MicroserviceApp.DataMicroservice.Models.TemperatureModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(Sink.class)
public class TemperatureListener {
    private Logger logger = LoggerFactory.getLogger(DataMicroserviceApplication.class);

    @StreamListener(Sink.INPUT)
    public void log(TemperatureModel temperatureModel) {
        logger.info("message has arrived :  " + temperatureModel.value);;
    }
}
