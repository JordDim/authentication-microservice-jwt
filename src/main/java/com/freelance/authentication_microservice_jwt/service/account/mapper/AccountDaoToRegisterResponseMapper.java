package com.freelance.authentication_microservice_jwt.service.account.mapper;

import com.freelance.authentication_microservice_jwt.domain.vo.RegisterResponse;
import com.freelance.authentication_microservice_jwt.model.Account;
import org.mapstruct.Mapper;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface AccountDaoToRegisterResponseMapper extends Converter<Account, RegisterResponse> {

	RegisterResponse convertToRegisterResponse(Account account);

}
