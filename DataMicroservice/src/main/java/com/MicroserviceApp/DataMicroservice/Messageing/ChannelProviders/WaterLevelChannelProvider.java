package com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface WaterLevelChannelProvider {
    String INPUT = "WaterLevelInput";

    @Input(INPUT)
    MessageChannel input();
}
