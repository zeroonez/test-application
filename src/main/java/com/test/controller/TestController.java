package com.test.controller;

import com.test.entity.Accounts;
import com.test.service.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/test")
public class TestController {

	public TestController(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	private final AccountRepository accountRepository;

	@GetMapping("/{number}")
	public void generateTestData(@PathVariable("number") long number) {
		for (long i = 1; i <= number; i++) {
			accountRepository.save(new Accounts(
					UUID.randomUUID().toString(),
					"MyName",
					1000
			));
		}
	}

	@GetMapping("/update")
	public void updateTestData() {
		List<Accounts> accounts = accountRepository.findAll();
		accounts.forEach(
				account -> {
					account.setAmount(2000);
					accountRepository.save(account);
				}
		);

	}
}
