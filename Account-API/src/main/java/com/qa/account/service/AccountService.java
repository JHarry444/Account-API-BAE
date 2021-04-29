package com.qa.account.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.qa.account.persistence.domain.Account;
import com.qa.account.persistence.repo.AccountRepo;

@Service
public class AccountService {

	private AccountRepo repo;

	private RestTemplate rest;

	public AccountService(AccountRepo repo, RestTemplate rest) {
		super();
		this.repo = repo;
		this.rest = rest;
	}

	public Account register(Account account) {
		// replace with GET request
		String accNumber = this.rest.getForObject("http://num-gen-api/genNum", String.class);
		account.setAccountNumber(accNumber);

		// replace with GET request
		String prizeAsString = this.rest.getForObject("http://prize-api/genPrize/" + accNumber, String.class);
		Integer prize = Integer.parseInt(prizeAsString);
		account.setPrize(prize);

		Account registeredAccount = this.repo.save(account);
		// push account to Q with JMS template - remember to convert it to a String
		// first!
		return registeredAccount;
	}
}
