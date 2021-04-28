package com.qa.account.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NumGenServiceUnitTest {

	@Autowired
	private NumberGenService numGenerator;

	@Test
	void genNumTest() {
		String pattern = "^[a-c]([0-9]{6}|\\d{8}|\\d{10})$";
		// ^ = start of string
		// [a-c] = a, b or c
		// ( ) = group
		// [0-9] = number from 0 to 9
		// {6} = repeat previous 6 times
		// | = OR
		// \d = any digit (basically identical to [0-9] but shorter)
		// $ = end of string
		for (int i = 0; i < 1_000_000; i++) {
			assertThat(numGenerator.genNumber()).matches(pattern);
		}
	}

}
