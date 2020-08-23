package com.MicroserviceApp.DataMicroservice.Runners;

import com.MicroserviceApp.DataMicroservice.Context.IBatchRepository;
import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.BatchChannelProvider;
import com.MicroserviceApp.DataMicroservice.Messageing.ServiceRegistrationChannelProvider;
import com.MicroserviceApp.DataMicroservice.Models.ServiceInfo;
import com.MicroserviceApp.DataMicroservice.Models.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.core.env.Environment;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.*;

@EnableBinding(BatchChannelProvider.class)
public class BatchSendRunner implements ApplicationRunner {


    @Value("${server.port}")
    private int servicePort;
    @Value("${server.ip_address}")
    private String serviceIpAddress;
    @Autowired
    private ServiceRegistrationChannelProvider serviceRegistrationChannelProvider;
    @Autowired
    IBatchRepository batchRepository;
    @Autowired
    private MessageChannel BatchOutput;
    @Autowired
    private Environment env;
    private Timer timer;
    private TimerTask task;

    private Date lastSend;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        registerService();
        int batchPeriod = Integer.parseInt(env.getProperty("app.batchPeriod"));
        lastSend = new Date();
        this.timer = new Timer();
        this.task = this.getTask();
        this.timer.schedule(this.task, batchPeriod, batchPeriod);
    }

    private TimerTask getTask(){
        return new TimerTask() {
            @Override
            public void run() {
                Date timeNow = new Date();
                HashMap weatherMap = batchRepository.getBatch(lastSend,timeNow);
                lastSend = timeNow;
                BatchOutput.send(MessageBuilder.withPayload(weatherMap).build());
            }
        };
    }

    private void registerService(){
        ServiceInfo serviceInfo = ServiceInfo.builder()
            .ipAddress(serviceIpAddress)
            .port(servicePort)
            .serviceType(ServiceType.DATA_SERVICE)
            .build();

        serviceRegistrationChannelProvider.getChanel().send(MessageBuilder.withPayload(serviceInfo).build());
    }

}
