package com.MicroserviceApp.DeviceMicroservice.Messageing.WeatehrSource;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PressureSource {
    String OUTPUT = "PressureOutput";

    @Output(PressureSource.OUTPUT)
    MessageChannel output();
}
