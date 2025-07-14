package com.freelance.authentication_microservice_jwt.service.account.impl;

import com.freelance.authentication_microservice_jwt.model.Account;
import com.freelance.authentication_microservice_jwt.repository.AccountRepository;
import com.freelance.authentication_microservice_jwt.security.AccountDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountDetailsServiceImpl implements UserDetailsService {

	private final AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Account account = accountRepository.findByUsername(username);
		if (account == null) {
			throw new UsernameNotFoundException("Username not found: " + username);
		}

		return new AccountDetails(account);
	}

}
