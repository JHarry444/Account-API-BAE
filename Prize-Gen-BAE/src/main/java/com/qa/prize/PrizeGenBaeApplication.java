package com.qa.prize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PrizeGenBaeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PrizeGenBaeApplication.class, args);
	}

}
