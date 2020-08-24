package com.MicroserviceApp.DeviceMicroservice.Messaging;

import org.springframework.messaging.MessageChannel;

public interface IChannelProvider {

    public MessageChannel getChanel();
}
