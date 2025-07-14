package com.freelance.authentication_microservice_jwt.properties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@AllArgsConstructor
public class SecurityProperties {

	private AuthProperties auth;

	private JWTProperties jwt;

}
