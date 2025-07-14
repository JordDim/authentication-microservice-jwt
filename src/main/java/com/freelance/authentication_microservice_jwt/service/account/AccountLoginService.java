package com.freelance.authentication_microservice_jwt.service.account;

import com.freelance.authentication_microservice_jwt.domain.vo.LoginRequest;
import com.freelance.authentication_microservice_jwt.domain.vo.LoginResponse;

public interface AccountLoginService {

	LoginResponse loginAccount(LoginRequest loginRequest);

}
