package com.api.helpr.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class LogTecnicoExclusao implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataExclusao;
	
	private Integer idTecnico;
	private String nomeTecnico;
	private Integer devCorrecao;
	
	public LogTecnicoExclusao() {
		super();
	}

	public LogTecnicoExclusao(Integer id, LocalDate dataExclusao, Integer idTecnico, String nomeTecnico,
			Integer devCorrecao
			) {
		super();
		this.id = id;
		this.dataExclusao = dataExclusao;
		this.idTecnico = idTecnico;
		this.nomeTecnico = nomeTecnico;
		this.devCorrecao = devCorrecao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDate getDataExclusao() {
		return dataExclusao;
	}

	public void setDataExclusao(LocalDate dataExclusao) {
		this.dataExclusao = dataExclusao;
	}

	public Integer getIdTecnico() {
		return idTecnico;
	}

	public void setIdTecnico(Integer idTecnico) {
		this.idTecnico = idTecnico;
	}

	public String getNomeTecnico() {
		return nomeTecnico;
	}

	public void setNomeTecnico(String nomeTecnico) {
		this.nomeTecnico = nomeTecnico;
	}

	public Integer getDevCorrecao() {
		return devCorrecao;
	}

	public void setDevCorrecao(Integer devCorrecao) {
		this.devCorrecao = devCorrecao;
	}
	
		
	
	
}
