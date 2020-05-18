package com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface PressureChannelProvider {
    String INPUT = "PressureInput";

    @Input(INPUT)
    MessageChannel input();
}
