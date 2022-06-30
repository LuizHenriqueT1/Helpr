package com.api.helpr.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.helpr.domain.ClienteFuturo;

public interface ClienteFuturoRepository extends JpaRepository<ClienteFuturo, Integer>{

	Optional<ClienteFuturo> findByEmail(String email);


}
