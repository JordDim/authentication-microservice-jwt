package com.freelance.authentication_microservice_jwt.service.account.impl;

import com.freelance.authentication_microservice_jwt.model.Account;
import com.freelance.authentication_microservice_jwt.repository.AccountRepository;
import com.freelance.authentication_microservice_jwt.service.account.AccountGetAllService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountGetAllServiceImpl implements AccountGetAllService {

	private final AccountRepository accountRepository;

	@Override
	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

}
