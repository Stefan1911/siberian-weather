package com.MicroserviceApp.AnalyticsMicroservice.StartUp;

import com.MicroserviceApp.AnalyticsMicroservice.ServiceRegistration.IServiceRegister;
import com.MicroserviceApp.AnalyticsMicroservice.ServiceRegistration.Models.ServiceType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RegistrationRunner implements ApplicationRunner {

  @Autowired
  private IServiceRegister serviceRegister;
  @Override
  public void run(ApplicationArguments args) throws Exception {
    System.out.println("#######################################################################");
    serviceRegister.registerService(ServiceType.ANALYTICS_SERVICE);
  }
}
