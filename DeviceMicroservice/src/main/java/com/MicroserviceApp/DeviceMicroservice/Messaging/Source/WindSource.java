package com.MicroserviceApp.DeviceMicroservice.Messaging.Source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface WindSource {
    String OUTPUT = "WindOutput";

    @Output(WindSource.OUTPUT)
    MessageChannel output();
}
