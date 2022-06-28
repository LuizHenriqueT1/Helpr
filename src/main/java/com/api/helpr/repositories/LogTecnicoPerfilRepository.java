package com.api.helpr.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.helpr.domain.LogTecnicoPerfil;

public interface LogTecnicoPerfilRepository extends JpaRepository<LogTecnicoPerfil, Integer>{
	
	@Query(value="SELECT * FROM log_chamado_Perfil WHERE data_alteracao = :dataDia", nativeQuery = true)
	List<LogTecnicoPerfil> findLogChamadoPerfilDia(LocalDate dataDia);

}
