package com.qa.disco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryServerBaeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryServerBaeApplication.class, args);
	}

}
