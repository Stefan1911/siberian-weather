package com.MicroserviceApp.DataMicroservice.Runners;

import com.MicroserviceApp.DataMicroservice.Context.IBatchRepository;
import com.MicroserviceApp.DataMicroservice.Messageing.ChannelProviders.BatchChannelProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.core.env.Environment;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.*;

@EnableBinding(BatchChannelProvider.class)
public class BatchSendRunner implements ApplicationRunner {

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
}
