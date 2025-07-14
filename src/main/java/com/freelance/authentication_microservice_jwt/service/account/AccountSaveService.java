package com.freelance.authentication_microservice_jwt.service.account;

import com.freelance.authentication_microservice_jwt.domain.vo.RegisterRequest;
import com.freelance.authentication_microservice_jwt.domain.vo.RegisterResponse;

public interface AccountSaveService {

	RegisterResponse saveAccount(RegisterRequest registerRequest);

}
