package com.MicroserviceApp.DeviceMicroservice.Messaging.Source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface PrecipitationSource {
    String OUTPUT = "PrecipitationOutput";

    @Output(PrecipitationSource.OUTPUT)
    MessageChannel output();
}
