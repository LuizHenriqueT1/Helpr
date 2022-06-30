package com.api.helpr.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.helpr.domain.Candidato;

public interface CandidatoRepository extends JpaRepository<Candidato, Integer> {
 
	@Query(value = "CALL sps_candidato_byNome(:nome)", nativeQuery = true)
	Optional<Candidato> findByNome(String nome);

}