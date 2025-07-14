package com.freelance.authentication_microservice_jwt.service.jwt.impl;

import com.freelance.authentication_microservice_jwt.service.jwt.JWTExtractAllClaimsService;
import com.freelance.authentication_microservice_jwt.service.jwt.JWTExtractClaimService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class JWTExtractClaimServiceImpl implements JWTExtractClaimService {

	private final JWTExtractAllClaimsService jwtExtractAllClaimsService;

	@Override
	public <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
		final Claims claims = jwtExtractAllClaimsService.extractAllClaims(token);
		return claimResolver.apply(claims);
	}

}
