package com.freelance.authentication_microservice_jwt.service.account.mapper;

import com.freelance.authentication_microservice_jwt.domain.vo.LoginResponse;
import com.freelance.authentication_microservice_jwt.security.AccountDetails;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.core.convert.converter.Converter;

@Mapper(componentModel = "spring")
public interface AccountDetailsToLoginResponseMapper extends Converter<AccountDetails, LoginResponse> {

	@Override
	@Mapping(source = "account.verificationToken", target = "token")
	LoginResponse convert(AccountDetails accountDetails);

}
