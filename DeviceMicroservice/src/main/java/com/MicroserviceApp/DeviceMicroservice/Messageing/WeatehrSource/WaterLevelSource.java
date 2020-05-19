package com.MicroserviceApp.DeviceMicroservice.Messageing.WeatehrSource;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface WaterLevelSource {
    String OUTPUT = "WaterLevelOutput";

    @Output(WaterLevelSource.OUTPUT)
    MessageChannel output();
}
