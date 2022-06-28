package com.api.helpr.repositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.helpr.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer>{
	@Query(value="CALL sps_chamados_abertos_soma_dia_tecnico(:tecnico, :diaAtual)", nativeQuery = true)
	Long findReportCallDayCount(Integer tecnico, LocalDate diaAtual);
	
	@Query(value="CALL sps_tecnicos_andamento(:tecnico);", nativeQuery = true)
	List<Chamado> findByTecnico(Integer tecnico);
	
	@Query(value="CALL sps_chamados_abertos_cliente(:cliente);", nativeQuery = true)
    List<Chamado> findByCliente(Integer cliente);

	@Query(value = "CALL sps_tarefas_encerradas_tecnico_semanal(:idTecnico, CURRENT_DATE())", nativeQuery = true)
	Optional<List<Chamado>> findByRelatorioTecnico(Integer idTecnico);
}