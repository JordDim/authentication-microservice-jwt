package com.freelance.authentication_microservice_jwt.service.jwt.impl;

import com.freelance.authentication_microservice_jwt.properties.ApplicationProperties;
import com.freelance.authentication_microservice_jwt.service.jwt.JWTGetSecretKeyService;
import io.jsonwebtoken.security.Keys;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;

@Service
@RequiredArgsConstructor
public class JWTGetSecretKeyServiceImpl implements JWTGetSecretKeyService {

	private final ApplicationProperties applicationProperties;

	@Override
	public SecretKey getSecretKey() {
		byte[] keyBytes = applicationProperties.getSecurity().getJwt().getSecretKey().getBytes(StandardCharsets.UTF_8);
		return Keys.hmacShaKeyFor(keyBytes);
	}

}
