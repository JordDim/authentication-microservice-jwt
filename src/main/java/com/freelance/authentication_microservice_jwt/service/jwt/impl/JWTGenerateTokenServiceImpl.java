package com.freelance.authentication_microservice_jwt.service.jwt.impl;

import com.freelance.authentication_microservice_jwt.service.jwt.JWTGenerateTokenService;
import com.freelance.authentication_microservice_jwt.service.jwt.JWTGetSecretKeyService;
import io.jsonwebtoken.Jwts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class JWTGenerateTokenServiceImpl implements JWTGenerateTokenService {

	private final JWTGetSecretKeyService jwtGetSecretKeyService;

	@Override
	public String generateToken(String username) {
		Map<String, Object> claims = new HashMap<>();
		return Jwts.builder()
			.subject(username)
			.claims()
			.add(claims)
			.issuedAt(new Date(System.currentTimeMillis()))
			.expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 30))
			.and()
			.signWith(jwtGetSecretKeyService.getSecretKey())
			.compact();
	}

}
