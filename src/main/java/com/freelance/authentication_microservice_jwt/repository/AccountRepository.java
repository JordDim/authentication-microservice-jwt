package com.freelance.authentication_microservice_jwt.repository;

import com.freelance.authentication_microservice_jwt.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

	Account findByUsername(String username);

}
