package com.MicroserviceApp.DeviceMicroservice.Messageing.ChannelProvider;

import com.MicroserviceApp.DeviceMicroservice.Messageing.IChannelProvider;
import com.MicroserviceApp.DeviceMicroservice.Messageing.WeatehrSource.WaterLevelSource;
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
