package com.api.helpr.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.helpr.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

@Query(value = "CALL sps_clientes_nomes(:nome)", nativeQuery = true )
	Optional<List<Cliente>> findCliente(String nome);



}