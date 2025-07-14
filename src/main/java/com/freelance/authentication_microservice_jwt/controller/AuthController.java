package com.freelance.authentication_microservice_jwt.controller;

import com.freelance.authentication_microservice_jwt.apifirst.api.AuthApiDelegate;
import com.freelance.authentication_microservice_jwt.domain.vo.LoginRequest;
import com.freelance.authentication_microservice_jwt.domain.vo.LoginResponse;
import com.freelance.authentication_microservice_jwt.domain.vo.RegisterRequest;
import com.freelance.authentication_microservice_jwt.domain.vo.RegisterResponse;
import com.freelance.authentication_microservice_jwt.model.Account;
import com.freelance.authentication_microservice_jwt.service.account.AccountGetAllService;
import com.freelance.authentication_microservice_jwt.service.account.AccountLoginService;
import com.freelance.authentication_microservice_jwt.service.account.AccountSaveService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthController implements AuthApiDelegate {

	private final AccountSaveService accountSaveService;

	private final AccountLoginService accountLoginService;

	private final AccountGetAllService accountGetAllService;

	@Override
	public ResponseEntity<LoginResponse> loginAccount(LoginRequest loginRequest) {
		return ResponseEntity.ok(accountLoginService.loginAccount(loginRequest));
	}

	@Override
	public ResponseEntity<RegisterResponse> registerAccount(RegisterRequest registerRequest) {
		return ResponseEntity.ok(accountSaveService.saveAccount(registerRequest));
	}

	@GetMapping("/getAll")
	public List<Account> getUsers() {
		return accountGetAllService.getAllAccounts();
	}

}
