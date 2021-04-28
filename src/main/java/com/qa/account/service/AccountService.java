package com.qa.account.service;

import org.springframework.stereotype.Service;

import com.qa.account.persistence.domain.Account;
import com.qa.account.persistence.repo.AccountRepo;

@Service
public class AccountService {

	private AccountRepo repo;

	private NumberGenService numberGenerator;

	private PrizeGenService prizeGenerator;

	public AccountService(AccountRepo repo, NumberGenService numberGenerator, PrizeGenService prizeGenerator) {
		super();
		this.repo = repo;
		this.numberGenerator = numberGenerator;
		this.prizeGenerator = prizeGenerator;
	}

	public Account register(Account account) {
		// replace with GET request
		String accNumber = numberGenerator.genNumber();
		account.setAccountNumber(accNumber);
		// replace with GET request
		Integer prize = this.prizeGenerator.genPrize(accNumber);
		account.setPrize(prize);

		Account registeredAccount = this.repo.save(account);
		return registeredAccount;
	}
}
