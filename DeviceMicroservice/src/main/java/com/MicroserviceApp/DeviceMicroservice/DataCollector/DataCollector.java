package com.MicroserviceApp.DeviceMicroservice.DataCollector;

import com.MicroserviceApp.DeviceMicroservice.DataCollector.Sensor.SensorProvider;
import com.MicroserviceApp.DeviceMicroservice.Messaging.ChannelProviderFactory;
import com.MicroserviceApp.DeviceMicroservice.Models.Enumerations.WeatherAttributeType;
import com.MicroserviceApp.DeviceMicroservice.Models.WeatherModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

@Component
public class DataCollector {
    private Timer timer;
    private TimerTask task;
    private WeatherAttributeType stat;
    private ChannelProviderFactory channelProviderFactory;
    private SensorProvider sensorProvider;
    private DataCollectorSettings dataCollectorSettings;

    @Autowired
    public DataCollector(ChannelProviderFactory channelProviderFactory, SensorProvider sensorProvider, DataCollectorSettings dataCollectorSettings) {
        this.channelProviderFactory = channelProviderFactory;
        this.sensorProvider = sensorProvider;
        this.dataCollectorSettings = dataCollectorSettings;
    }

    public void startReading(){
        this.stat = dataCollectorSettings.getValueType();
        this.timer = new Timer();
        this.task = this.getTask();
        this.timer.schedule(this.task, 0, this.dataCollectorSettings.getReadRate());
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
                Double value = null;
                try {
                    value = sensorProvider.getSensor(stat).nextValue();
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }
                WeatherModel model = new WeatherModel(value,new Date());
                channelProviderFactory
                        .getProvider(stat)
                        .getChanel()
                        .send(MessageBuilder.withPayload(model).build());
            }
        };
    }
}
