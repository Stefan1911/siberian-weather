package com.MicroserviceApp.ActuatorService.Actuators;

import com.MicroserviceApp.ActuatorService.Models.CommandParameters;

public interface IActuator {
    public void Actuate(CommandParameters parameters);
}
