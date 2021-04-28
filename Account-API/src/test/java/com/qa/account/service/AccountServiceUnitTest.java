package com.qa.account.service;

import static org.assertj.core.api.Assertions.assertThat;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.qa.account.persistence.domain.Account;
import com.qa.account.persistence.repo.AccountRepo;

@SpringBootTest
public class AccountServiceUnitTest {

	@Autowired
	private AccountService service;

	@MockBean
	private AccountRepo repo;

//	@Test
	void testRegister() {
		// GIVEN

		final Account testAccount = new Account("jh", "pass");

		final String testAccountNumber = "c1234567890";

		final int testPrize = 10_000;

		final Account testRegisteredAccount = new Account(1L, testAccount.getUsername(), testAccount.getPassword(),
				testAccountNumber, testPrize);

		// WHEN

		Mockito.when(this.numberGenerator.genNumber()).thenReturn(testAccountNumber);

		Mockito.when(this.prizeGenerator.genPrize(testAccountNumber)).thenReturn(testPrize);

		Mockito.when(this.repo.save(testAccount)).thenReturn(testRegisteredAccount);

		// THEN

		assertThat(this.service.register(testAccount)).isEqualTo(testRegisteredAccount);
	}
}
