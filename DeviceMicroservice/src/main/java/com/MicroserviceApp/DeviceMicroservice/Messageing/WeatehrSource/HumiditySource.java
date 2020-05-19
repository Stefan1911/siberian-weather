package com.MicroserviceApp.DeviceMicroservice.Messageing.WeatehrSource;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface HumiditySource {
    String OUTPUT = "HumidityOutput";

    @Output(HumiditySource.OUTPUT)
    MessageChannel output();
}
