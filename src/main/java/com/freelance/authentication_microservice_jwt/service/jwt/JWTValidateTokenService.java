package com.freelance.authentication_microservice_jwt.service.jwt;

import org.springframework.security.core.userdetails.UserDetails;

public interface JWTValidateTokenService {

	boolean validateToken(String token, UserDetails userDetails);

}
