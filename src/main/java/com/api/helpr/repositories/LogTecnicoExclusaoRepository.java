package com.api.helpr.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.api.helpr.domain.LogTecnicoExclusao;

public interface LogTecnicoExclusaoRepository extends JpaRepository<LogTecnicoExclusao, Integer>{

	@Query(value="SELECT * FROM log_tecnico_exclusao", nativeQuery = true)
	List<LogTecnicoExclusao> findLogTecnicoExclusao();

	
}
