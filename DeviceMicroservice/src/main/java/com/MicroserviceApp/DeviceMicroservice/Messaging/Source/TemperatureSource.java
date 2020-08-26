package com.MicroserviceApp.DeviceMicroservice.Messaging.Source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface TemperatureSource {
    String OUTPUT = "TemperatureOutput";

    @Output(TemperatureSource.OUTPUT)
    MessageChannel output();
}
