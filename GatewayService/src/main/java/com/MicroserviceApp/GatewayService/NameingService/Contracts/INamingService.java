package com.MicroserviceApp.GatewayService.NameingService.Contracts;

import com.MicroserviceApp.GatewayService.Gateway.DTOs.Command;
import com.MicroserviceApp.GatewayService.Gateway.DTOs.EventDTO;
import com.MicroserviceApp.GatewayService.NameingService.Models.ServiceInfo;
import com.MicroserviceApp.GatewayService.NameingService.Models.ServiceType;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import org.springframework.http.ResponseEntity;

public interface INamingService {

  void register(ServiceInfo serviceInfo);
  Optional<ServiceInfo> getFirstOrDefaultActuator();
  Map<ServiceType, Set<ServiceInfo>> getAllServices();
  void removeFromRegistry(ServiceInfo serviceInfo);
  Optional<ServiceInfo> getCommandService();

  ResponseEntity<EventDTO[]> getAllEvents();

  String getAllCommands();

  void executeCommand(Command command);
}
