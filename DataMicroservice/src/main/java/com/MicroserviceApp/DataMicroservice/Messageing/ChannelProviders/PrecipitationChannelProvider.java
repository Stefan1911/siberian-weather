package com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface PrecipitationChannelProvider {
    String INPUT = "PrecipitationInput";

    @Input(INPUT)
    MessageChannel input();
}
