package com.freelance.authentication_microservice_jwt.service.jwt;

import io.jsonwebtoken.Claims;

public interface JWTExtractAllClaimsService {

	Claims extractAllClaims(String token);

}
