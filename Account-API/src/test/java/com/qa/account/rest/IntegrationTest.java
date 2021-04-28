package com.qa.account.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.account.persistence.domain.Account;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class IntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testRegister() throws Exception {
		final Account testAccount = new Account("jh", "pass");
		final String testAccountAsJSON = this.mapper.writeValueAsString(testAccount);
		RequestBuilder request = post("/register").content(testAccountAsJSON).contentType(MediaType.APPLICATION_JSON);

		ResultMatcher checkStatus = status().isCreated();

		String registeredAccountAsJSON = mvc.perform(request).andExpect(checkStatus).andReturn().getResponse()
				.getContentAsString();

		Account registeredAccount = this.mapper.readValue(registeredAccountAsJSON, Account.class);

		assertThat(registeredAccount.getId()).isEqualTo(1L);
		assertThat(registeredAccount.getUsername()).isEqualTo(testAccount.getUsername());
		assertThat(registeredAccount.getPassword()).isEqualTo(testAccount.getPassword());
		assertThat(registeredAccount.getAccountNumber()).matches("^[a-c]([0-9]{6}|\\d{8}|\\d{10})$");
		assertThat(registeredAccount.getPrize()).isIn(0, 50, 500, 5_000, 100, 750, 10_000);

	}
}
