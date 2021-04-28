package com.qa.num.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class NumberGenService {

	private Random random = new Random();

	private final String[] characters = { "a", "b", "c" };

	public String genNumber() {
		String accountNumber = "";

		accountNumber += characters[random.nextInt(3)];

		int numDigits = 0;
		// 0/2/4
		numDigits = 6 + (random.nextInt(3) * 2);

		for (int i = 0; i < numDigits; i++) {
			accountNumber += random.nextInt(10);
		}

		return accountNumber;
	}
}
