package com.MicroserviceApp.AnalyticsMicroservice.ServiceRegistration;


import com.MicroserviceApp.AnalyticsMicroservice.ServiceRegistration.Models.ServiceType;

public interface IServiceRegister {
  public void registerService(ServiceType serviceType);
}
