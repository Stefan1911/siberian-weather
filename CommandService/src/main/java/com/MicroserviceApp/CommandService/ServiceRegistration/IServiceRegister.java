package com.MicroserviceApp.CommandService.ServiceRegistration;

import com.MicroserviceApp.CommandService.ServiceRegistration.Models.ServiceType;

public interface IServiceRegister {
  public void registerService(ServiceType serviceType);
}
