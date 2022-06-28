package com.api.helpr.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.helpr.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{
	@Query(value="SELECT * FROM chamado WHERE tecnico_id = :tecnico AND status =1", nativeQuery = true)
	List<Chamado> findByTecnico(Integer tecnico);
	
	@Query(value="CALL sps_chamados_abertos_cliente(:cliente);", nativeQuery = true)
    List<Chamado> findByCliente(Integer cliente);

	@Query(value = "CALL sps_tarefas_encerradas_tecnico_semanal(:idTecnico, CURRENT_DATE())", nativeQuery = true)
	Optional<List<Chamado>> findByRelatorioTecnico(Integer idTecnico);
}