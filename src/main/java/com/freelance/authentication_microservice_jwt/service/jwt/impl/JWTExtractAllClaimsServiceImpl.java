package com.freelance.authentication_microservice_jwt.service.jwt.impl;

import com.freelance.authentication_microservice_jwt.service.jwt.JWTExtractAllClaimsService;
import com.freelance.authentication_microservice_jwt.service.jwt.JWTGetSecretKeyService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JWTExtractAllClaimsServiceImpl implements JWTExtractAllClaimsService {

	private final JWTGetSecretKeyService jwtGetSecretKeyService;

	@Override
	public Claims extractAllClaims(String token) {
		return Jwts.parser()
			.verifyWith(jwtGetSecretKeyService.getSecretKey())
			.build()
			.parseSignedClaims(token)
			.getPayload();
	}

}
