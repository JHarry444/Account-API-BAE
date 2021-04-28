package com.qa.account.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.account.persistence.domain.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, Long> {

	// bit after findBy MUST match a field in the entity
	Account findByUsername(String username);

}
