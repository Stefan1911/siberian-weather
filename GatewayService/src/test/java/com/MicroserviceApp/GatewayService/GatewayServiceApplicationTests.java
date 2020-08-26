package com.MicroserviceApp.GatewayService;

import com.MicroserviceApp.GatewayService.NameingService.Models.ServiceInfo;
import com.MicroserviceApp.GatewayService.NameingService.Models.ServiceType;
import java.util.HashSet;
import java.util.Set;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class GatewayServiceApplicationTests {

	@Test
	void contextLoads() {

		ServiceInfo serviceInfo = new ServiceInfo(ServiceType.COMMAND_SERVICE,"my addres",1234, null	);
		ServiceInfo serviceInfo2 = new ServiceInfo(ServiceType.COMMAND_SERVICE,"my addres",1234,null	);

		Set<ServiceInfo> serviceInfoSet = new HashSet<>();

		serviceInfoSet.add(serviceInfo);
		serviceInfoSet.add(serviceInfo2);

		System.out.println(serviceInfoSet);
		Assertions.assertEquals(1,serviceInfoSet.size());
	}

}
