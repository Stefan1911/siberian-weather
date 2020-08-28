package com.MicroserviceApp.DeviceMicroservice.Startup;

import com.MicroserviceApp.DeviceMicroservice.ActuatorHandler.Models.ActuatorType;
import com.MicroserviceApp.DeviceMicroservice.DataCollector.DataCollector;
import com.MicroserviceApp.DeviceMicroservice.Messaging.ChannelProvider.ServiceRegistrationChannelProvider;
import com.MicroserviceApp.DeviceMicroservice.Models.Enumerations.ServiceType;
import com.MicroserviceApp.DeviceMicroservice.Models.Enumerations.WeatherAttributeType;
import com.MicroserviceApp.DeviceMicroservice.Models.ServiceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
public class weatherRunner implements ApplicationRunner {

    @Autowired
    private DataCollector dataController;
    @Autowired
    private ServiceRegistrationChannelProvider serviceRegistrationChannelProvider;

    @Value("${server.port}")
    private int servicePort;
    @Value("${server.ip_address}")
    private String serviceIpAddress;
    @Value("${collector.type}")
    WeatherAttributeType weatherAttributeType;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        registerService();
        dataController.startReading();
    }

    public DataCollector getDataController(WeatherAttributeType stat){
        return dataController;
    }

    private void registerService(){
        registerServiceAs(ServiceType.DEVICE_SERVICE,null,weatherAttributeType);
        registerServiceAs(ServiceType.ACTUATOR_SERVICE,ActuatorType.SIREN,null);
    }

    private void registerServiceAs(ServiceType serviceType, ActuatorType actuatorType,WeatherAttributeType weatherAttributeType){
        ServiceInfo serviceInfo = ServiceInfo.builder()
            .ipAddress(serviceIpAddress)
            .port(servicePort)
            .serviceType(serviceType)
            .actuatorType(actuatorType)
            .weatherAttributeType(weatherAttributeType)
            .build();

        serviceRegistrationChannelProvider.getChanel().send(MessageBuilder.withPayload(serviceInfo).build());
    }



    //todo remove this functions
    public void restartDataController(){
        dataController.restartReading();
    }
    public void startDataController(){
        dataController.startReading();
    }
    public void stopDataController(){
        dataController.stopReading();
    }
}
