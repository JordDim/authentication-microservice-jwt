package com.freelance.authentication_microservice_jwt.service.account;

import com.freelance.authentication_microservice_jwt.model.Account;

import java.util.List;

public interface AccountGetAllService {

	List<Account> getAllAccounts();

}
