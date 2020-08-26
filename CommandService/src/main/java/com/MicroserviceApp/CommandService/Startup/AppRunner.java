package com.MicroserviceApp.CommandService.Startup;

import com.MicroserviceApp.CommandService.ServiceRegistration.IServiceRegister;
import com.MicroserviceApp.CommandService.ServiceRegistration.Models.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class AppRunner implements ApplicationRunner {

  @Autowired
  private IServiceRegister serviceRegister;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    serviceRegister.registerService(ServiceType.COMMAND_SERVICE);
  }

}
