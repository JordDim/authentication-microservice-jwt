package com.freelance.authentication_microservice_jwt.service.account.impl;

import com.freelance.authentication_microservice_jwt.domain.vo.LoginRequest;
import com.freelance.authentication_microservice_jwt.domain.vo.LoginResponse;
import com.freelance.authentication_microservice_jwt.security.AccountDetails;
import com.freelance.authentication_microservice_jwt.service.account.AccountLoginService;
import com.freelance.authentication_microservice_jwt.service.jwt.impl.JWTGenerateTokenServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountLoginServiceImpl implements AccountLoginService {

	private final ConversionService conversionService;

	private final AuthenticationManager authenticationManager;

	private final JWTGenerateTokenServiceImpl jwtService;

	@Override
	public LoginResponse loginAccount(LoginRequest loginRequest) {

		log.info("INIT - AccountLoginServiceImpl -> loginAccount() - Authenticating...");
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));

		if (!authentication.isAuthenticated()) {
			log.info("FAIL - AccountLoginServiceImpl -> loginAccount() - Authentication failed.");
			return null;
		}

		AccountDetails accountDetails = (AccountDetails) authentication.getPrincipal();
		log.info("SUCCESS - loginAccount() - Authenticated user: {}", accountDetails.getUsername());

		// Token Generation
		accountDetails.setToken(jwtService.generateToken(accountDetails.getUsername()));

		return conversionService.convert(accountDetails, LoginResponse.class);
	}

}
