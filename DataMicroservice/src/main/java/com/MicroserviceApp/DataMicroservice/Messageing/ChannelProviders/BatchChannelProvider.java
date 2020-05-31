package com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface BatchChannelProvider {
    String OUTPUT = "BatchOutput";

    @Output(BatchChannelProvider.OUTPUT)
    MessageChannel output();
}
