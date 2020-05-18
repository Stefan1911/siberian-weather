package com.MicroserviceApp.DeviceMicroservice.Messageing;

import org.springframework.messaging.MessageChannel;

public interface IChannelProvider {

    public MessageChannel getChanel();
}
