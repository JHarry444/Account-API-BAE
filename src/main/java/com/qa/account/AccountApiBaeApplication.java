package com.qa.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.account.persistence.domain.Account;
import com.qa.account.rest.AccountController;

@SpringBootApplication
public class AccountApiBaeApplication {

	public static void main(String[] args) throws JsonProcessingException {
		ApplicationContext beanBag = SpringApplication.run(AccountApiBaeApplication.class, args);

		// EXAMPLE FOR MICHAEL - DO NOT USE IN PRODUCTION!!111!!

		ObjectMapper mapper = beanBag.getBean(ObjectMapper.class);
		AccountController controller = beanBag.getBean(AccountController.class);

		// incoming from postman or w/e
		String newAccountAsJSON = "{\"username\":\"Mike\",\"password\":\"mickeyD\"}";

		Account account = mapper.readValue(newAccountAsJSON, Account.class);

		Account savedAccount = controller.createAccount(account).getBody();

		// outgoing
		String savedJSON = mapper.writeValueAsString(savedAccount);

		System.out.println("OUTPUT: " + savedJSON);
	}

}
