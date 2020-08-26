package com.MicroserviceApp.DeviceMicroservice.Messaging.Source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface VisibilitySource {
    String OUTPUT = "VisibilityOutput";

    @Output(VisibilitySource.OUTPUT)
    MessageChannel output();
}
