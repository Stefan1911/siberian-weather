package com.MicroserviceApp.DeviceMicroservice.Messaging.ChannelProvider;

import com.MicroserviceApp.DeviceMicroservice.Messaging.IChannelProvider;
import com.MicroserviceApp.DeviceMicroservice.Messaging.Source.HumiditySource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(HumiditySource.class)
public class HumidityChannelProvider implements IChannelProvider {
    @Autowired
    private MessageChannel HumidityOutput;

    @Override
    public MessageChannel getChanel() {
        return this.HumidityOutput;
    }
}
