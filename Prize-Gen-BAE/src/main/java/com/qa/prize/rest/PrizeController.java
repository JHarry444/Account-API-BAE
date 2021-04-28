package com.qa.prize.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.qa.prize.service.PrizeGenService;

@RestController
public class PrizeController {

	private PrizeGenService service;

	public PrizeController(PrizeGenService service) {
		super();
		this.service = service;
	}

	@GetMapping("/genPrize/{accNumber}")
	public String genPrize(@PathVariable String accNumber) {
		// converting to a string as it's more convenient to send
		return String.valueOf(this.service.genPrize(accNumber));
	}
}
