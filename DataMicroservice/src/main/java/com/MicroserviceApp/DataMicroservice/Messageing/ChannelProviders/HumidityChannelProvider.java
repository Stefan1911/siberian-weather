package com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface HumidityChannelProvider {
    String INPUT = "HumidityInput";

    @Input(INPUT)
    MessageChannel input();
}
