package com.api.helpr.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.helpr.domain.Tecnico;

public interface TecnicoRepository extends JpaRepository<Tecnico, Integer>{
	@Query(value = "CALL sps_tecnicos_nomes(:nome)", nativeQuery = true )
	Optional<List<Tecnico>> findTecnico(String nome);

}