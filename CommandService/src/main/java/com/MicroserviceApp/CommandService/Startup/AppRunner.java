package com.MicroserviceApp.CommandService.Startup;

import com.MicroserviceApp.CommandService.Models.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

  @Autowired
  private ServiceRegistration serviceRegistration;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    serviceRegistration.registerService(ServiceType.COMMAND_SERVICE);
  }

}
