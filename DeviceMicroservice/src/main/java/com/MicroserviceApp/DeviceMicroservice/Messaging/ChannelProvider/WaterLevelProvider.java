package com.MicroserviceApp.DeviceMicroservice.Messaging.ChannelProvider;

import com.MicroserviceApp.DeviceMicroservice.Messaging.IChannelProvider;
import com.MicroserviceApp.DeviceMicroservice.Messaging.Source.WaterLevelSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(WaterLevelSource.class)
public class WaterLevelProvider implements IChannelProvider {
    @Autowired
    private MessageChannel WaterLevelOutput;

    @Override
    public MessageChannel getChanel() {
        return this.WaterLevelOutput;
    }
}
