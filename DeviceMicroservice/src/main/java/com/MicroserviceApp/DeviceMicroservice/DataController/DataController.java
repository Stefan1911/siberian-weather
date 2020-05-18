package com.MicroserviceApp.DeviceMicroservice.DataController;

import com.MicroserviceApp.DeviceMicroservice.DataController.Sensor.ISensor;
import com.MicroserviceApp.DeviceMicroservice.Messageing.IChannelProvider;
import com.MicroserviceApp.DeviceMicroservice.Models.WeatherModel;
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
    private IChannelProvider channelProvider;
    private ISensor senzor;
    private int readDelay;
    private Timer timer;

    public DataController(IChannelProvider channelProvider, ISensor senzor, int readDelay) {
        this.channelProvider = channelProvider;
        this.senzor = senzor;
        this.readDelay = readDelay;
        this.timer = new Timer();
    }



    public void startReading(){
        this.timer.schedule(this.task, 0, this.readDelay);
    }
    public  void  stopReading(){
        this.timer.cancel();
    }
    public void restartReading(){
        this.stopReading();
        this.startReading();
    }

    TimerTask task = new TimerTask() {
        public void run() {
            int value = senzor.nextValue();
            WeatherModel model = new WeatherModel(value,new Date());
            channelProvider
                    .getChanel()
                    .send(MessageBuilder.withPayload(model).build());
        }
    };

}
