package com.freelance.authentication_microservice_jwt.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class JWTProperties {

	private String secretKey;

}
