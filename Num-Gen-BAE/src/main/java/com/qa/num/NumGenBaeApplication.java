package com.qa.num;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class NumGenBaeApplication {

	public static void main(String[] args) {
		SpringApplication.run(NumGenBaeApplication.class, args);
	}

}
