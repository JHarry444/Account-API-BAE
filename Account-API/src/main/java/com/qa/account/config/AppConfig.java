package com.qa.account.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

	@LoadBalanced // enables load-balancing and name resolution
	@Bean // tells Spring to make this RestTemplate for us
	public RestTemplate loadBalancedRestTemplate() {
		return new RestTemplate();
	}
}
