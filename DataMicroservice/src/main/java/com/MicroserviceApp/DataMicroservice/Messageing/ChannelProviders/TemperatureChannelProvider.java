package com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface TemperatureChannelProvider {
    String INPUT = "TemperatureInput";

    @Input(INPUT)
    MessageChannel input();
}
