package com.MicroserviceApp.DeviceMicroservice.Messaging.Source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PressureSource {
    String OUTPUT = "PressureOutput";

    @Output(PressureSource.OUTPUT)
    MessageChannel output();
}
