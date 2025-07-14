package com.freelance.authentication_microservice_jwt.service.account.impl;

import com.freelance.authentication_microservice_jwt.domain.vo.RegisterRequest;
import com.freelance.authentication_microservice_jwt.domain.vo.RegisterResponse;
import com.freelance.authentication_microservice_jwt.model.Account;
import com.freelance.authentication_microservice_jwt.repository.AccountRepository;
import com.freelance.authentication_microservice_jwt.service.account.AccountSaveService;
import com.freelance.authentication_microservice_jwt.service.account.factory.AccountFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountSaveServiceImpl implements AccountSaveService {

	private final AccountRepository accountRepository;

	private final ConversionService conversionService;

	private final PasswordEncoder passwordEncoder;

	@Override
	public RegisterResponse saveAccount(RegisterRequest registerRequest) {

		log.info("INIT - AccountSaveServiceImpl -> saveAccount() - Saving account {}", registerRequest);
		registerRequest.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
		Account account = AccountFactory.buildAccount(registerRequest);

		account = accountRepository.save(account);
		log.info("END - AccountSaveServiceImpl -> saveAccount() - Saved account {}", account);

		return conversionService.convert(account, RegisterResponse.class);
	}

}
