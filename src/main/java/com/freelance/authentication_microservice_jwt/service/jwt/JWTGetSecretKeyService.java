package com.freelance.authentication_microservice_jwt.service.jwt;

import javax.crypto.SecretKey;

public interface JWTGetSecretKeyService {

	SecretKey getSecretKey();

}
