package com.qa.consumer.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

@Service
public class ConsumerService {

	@JmsListener(destination = "account-q")
	public void receiveMessageFromQ(String message) {

		System.out.println("RECEIVED: <" + message + ">");
	}
}
