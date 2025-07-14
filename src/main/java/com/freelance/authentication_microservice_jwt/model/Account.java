package com.freelance.authentication_microservice_jwt.model;

import com.freelance.authentication_microservice_jwt.util.enums.RoleEnum;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;

	private String password;

	private String email;

	private String verificationToken;

	private Integer expiresIn;

	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private RoleEnum role;

	@Override
	public String toString() {
		return "Account{" + "id=" + id + ", username='" + username + '\'' + ", email='" + email + '\''
				+ ", verificationToken='" + verificationToken + '\'' + ", expiresIn=" + expiresIn + ", role=" + role
				+ '}';
	}

}
