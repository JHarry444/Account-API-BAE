package com.qa.prize.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PrizeGenServiceTest {

	@Autowired
	private PrizeGenService service;

	@Test
	void testPrizeGenNull() {
		assertThat(this.service.genPrize(null)).isEqualTo(0);
	}

	@Test
	void testPrizeGenInvalid() {
		assertThat(this.service.genPrize("d123456")).isEqualTo(0);
		assertThat(this.service.genPrize("a1234567")).isEqualTo(0);
		assertThat(this.service.genPrize("a123456a")).isEqualTo(0);
	}

	@Test
	void testPrizeGenA() {
		final String testAccountNum6 = "a123456";
		final String testAccountNum8 = "a12345678";
		final String testAccountNum10 = "a1234567890";

		assertThat(service.genPrize(testAccountNum6)).isEqualTo(0);
		assertThat(service.genPrize(testAccountNum8)).isEqualTo(0);
		assertThat(service.genPrize(testAccountNum10)).isEqualTo(0);
	}

	@Test
	void testPrizeGenB() {
		final String testAccountNum6 = "b123456";
		final String testAccountNum8 = "b12345678";
		final String testAccountNum10 = "b1234567890";

		assertThat(service.genPrize(testAccountNum6)).isEqualTo(50);
		assertThat(service.genPrize(testAccountNum8)).isEqualTo(500);
		assertThat(service.genPrize(testAccountNum10)).isEqualTo(5_000);
	}

	@Test
	void testPrizeGenC() {
		final String testAccountNum6 = "c123456";
		final String testAccountNum8 = "c12345678";
		final String testAccountNum10 = "c1234567890";

		assertThat(service.genPrize(testAccountNum6)).isEqualTo(100);
		assertThat(service.genPrize(testAccountNum8)).isEqualTo(750);
		assertThat(service.genPrize(testAccountNum10)).isEqualTo(10_000);
	}

}
