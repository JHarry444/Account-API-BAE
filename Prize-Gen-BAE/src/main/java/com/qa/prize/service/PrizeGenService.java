package com.qa.prize.service;

import org.springframework.stereotype.Service;

//Move to new project
@Service
public class PrizeGenService {

	public int genPrize(String accNumber) {
		int prize = 0;

		if (accNumber == null || accNumber.startsWith("a")) {
			prize = 0;
		} else if (accNumber.startsWith("b")) {
			if (accNumber.length() == 7) {
				prize = 50;
			} else if (accNumber.length() == 9) {
				prize = 500;
			} else if (accNumber.length() == 11) {
				prize = 5_000;
			}
		} else if (accNumber.startsWith("c")) {
			if (accNumber.length() == 7) {
				prize = 100;
			} else if (accNumber.length() == 9) {
				prize = 750;
			} else if (accNumber.length() == 11) {
				prize = 10_000;
			}
		}
		return prize;
	}
}
