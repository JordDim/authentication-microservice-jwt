package com.freelance.authentication_microservice_jwt.service.jwt.impl;

import com.freelance.authentication_microservice_jwt.service.jwt.JWTExtractClaimService;
import com.freelance.authentication_microservice_jwt.service.jwt.JWTGetAccountNameService;
import com.freelance.authentication_microservice_jwt.service.jwt.JWTValidateTokenService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class JWTValidateTokenServiceImpl implements JWTValidateTokenService {

	private final JWTGetAccountNameService jwtGetAccountNameService;

	private final JWTExtractClaimService jwtExtractClaimService;

	@Override
	public boolean validateToken(String token, UserDetails userDetails) {
		final String userName = jwtGetAccountNameService.getAccountName(token);
		return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}

	private Date extractExpiration(String token) {
		return jwtExtractClaimService.extractClaim(token, Claims::getExpiration);
	}

}
