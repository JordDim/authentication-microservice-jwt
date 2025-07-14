package com.freelance.authentication_microservice_jwt.service.jwt.impl;

import com.freelance.authentication_microservice_jwt.service.jwt.JWTExtractClaimService;
import com.freelance.authentication_microservice_jwt.service.jwt.JWTGetAccountNameService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JWTGetAccountNameServiceImpl implements JWTGetAccountNameService {

	private final JWTExtractClaimService jwtExtractClaimService;

	@Override
	public String getAccountName(String token) {
		return jwtExtractClaimService.extractClaim(token, Claims::getSubject);
	}

}
