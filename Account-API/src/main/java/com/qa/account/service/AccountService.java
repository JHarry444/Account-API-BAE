package com.qa.account.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qa.account.persistence.domain.Account;
import com.qa.account.persistence.repo.AccountRepo;

@Service
public class AccountService {

	private AccountRepo repo;

	private RestTemplate rest;

	public AccountService(AccountRepo repo, RestTemplateBuilder builder) {
		super();
		this.repo = repo;
		this.rest = builder.build();
	}

	public Account register(Account account) {
		// replace with GET request
		String accNumber = this.rest.getForObject("http://localhost:8082/genNum", String.class);
		account.setAccountNumber(accNumber);

		// replace with GET request
		String prizeAsString = this.rest.getForObject("http://localhost:8083/genPrize/" + accNumber, String.class);
		Integer prize = Integer.parseInt(prizeAsString);
		account.setPrize(prize);

		Account registeredAccount = this.repo.save(account);
		return registeredAccount;
	}
}
