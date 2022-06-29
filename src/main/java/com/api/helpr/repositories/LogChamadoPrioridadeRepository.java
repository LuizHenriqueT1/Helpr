package com.api.helpr.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.helpr.domain.LogChamadoPrioridade;

public interface LogChamadoPrioridadeRepository extends JpaRepository<LogChamadoPrioridade, Integer>{

	@Query(value="SELECT * FROM log_chamado_prioridade WHERE data_alteracao = :dataDia", nativeQuery = true)
	List<LogChamadoPrioridade> findLogChamadoPrioridadeDia(LocalDate dataDia);
}
