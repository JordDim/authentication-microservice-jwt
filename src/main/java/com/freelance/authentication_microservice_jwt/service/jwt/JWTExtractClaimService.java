package com.freelance.authentication_microservice_jwt.service.jwt;

import io.jsonwebtoken.Claims;

import java.util.function.Function;

public interface JWTExtractClaimService {

	<T> T extractClaim(String token, Function<Claims, T> claimResolver);

}
