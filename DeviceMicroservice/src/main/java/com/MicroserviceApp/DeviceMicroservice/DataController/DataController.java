package com.MicroserviceApp.DeviceMicroservice.DataController;

import com.MicroserviceApp.DeviceMicroservice.DataController.Sensor.ISensor;
import com.MicroserviceApp.DeviceMicroservice.DataController.Sensor.SensorProvider;
import com.MicroserviceApp.DeviceMicroservice.Messageing.ChannelProviderFactory;
import com.MicroserviceApp.DeviceMicroservice.Messageing.IChannelProvider;
import com.MicroserviceApp.DeviceMicroservice.Models.WeatherModel;
import com.MicroserviceApp.DeviceMicroservice.startup.weatherRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class DataController {
    private Timer timer;
    private TimerTask task;
    private weatherRunner.WeatherStats stat;
    private ChannelProviderFactory channelProviderFactory;
    private SensorProvider sensorProvider;
    private DataControllerSettings dataControllerSettings;

    public DataController(weatherRunner.WeatherStats stat, ChannelProviderFactory channelProviderFactory, SensorProvider sensorProvider, DataControllerSettings dataControllerSettings) {
        this.stat = stat;
        this.channelProviderFactory = channelProviderFactory;
        this.sensorProvider = sensorProvider;
        this.dataControllerSettings = dataControllerSettings;
    }

    public void startReading(){
        this.timer = new Timer();
        this.task = this.getTask();
        this.timer.schedule(this.task, 0, this.dataControllerSettings.getStat(this.stat));
    }
    public  void  stopReading(){
        this.timer.cancel();
        this.timer.purge();
    }
    public void restartReading(){
        this.stopReading();
        this.startReading();
    }

    private TimerTask getTask(){
        return new TimerTask() {
            @Override
            public void run() {
                int value = sensorProvider.getSensor(stat).nextValue();
                WeatherModel model = new WeatherModel(value,new Date());
                channelProviderFactory
                        .getProvider(stat)
                        .getChanel()
                        .send(MessageBuilder.withPayload(model).build());
            }
        };
    }
}
