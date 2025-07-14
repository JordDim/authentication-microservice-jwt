package com.freelance.authentication_microservice_jwt.service.account.factory;

import com.freelance.authentication_microservice_jwt.domain.vo.RegisterRequest;
import com.freelance.authentication_microservice_jwt.model.Account;
import com.freelance.authentication_microservice_jwt.util.enums.RoleEnum;

public class AccountFactory {

	// Empty constructor so there cant be instances of this class
	private AccountFactory() {
	}

	public static Account buildAccount(RegisterRequest registerRequest) {
		return Account.builder()
			.username(registerRequest.getUsername())
			.password(registerRequest.getPassword())
			.email(registerRequest.getEmail())
			.role(RoleEnum.valueOf(registerRequest.getRole().toUpperCase()))
			.build();
	}

}
