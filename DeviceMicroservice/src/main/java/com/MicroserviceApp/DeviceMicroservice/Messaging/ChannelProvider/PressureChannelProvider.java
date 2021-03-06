package com.MicroserviceApp.DeviceMicroservice.Messaging.ChannelProvider;

import com.MicroserviceApp.DeviceMicroservice.Messaging.IChannelProvider;
import com.MicroserviceApp.DeviceMicroservice.Messaging.Source.PressureSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(PressureSource.class)
public class PressureChannelProvider implements IChannelProvider {
    @Autowired
    private MessageChannel PressureOutput;

    @Override
    public MessageChannel getChanel() {
        return this.PressureOutput;
    }
}
