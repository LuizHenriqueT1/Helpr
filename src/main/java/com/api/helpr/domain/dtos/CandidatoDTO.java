package com.api.helpr.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.api.helpr.domain.Candidato;
import com.fasterxml.jackson.annotation.JsonFormat;

public class CandidatoDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	protected Integer id;
	@NotNull(message ="O campo de NOME é requerido.")
	protected String nome;
	@NotNull(message ="O campo de EMAIL é requerido.")
	protected String email;
	@NotNull(message ="O campo de LINKEDIN é requerido.")
	protected String linkedin;
	@NotNull(message ="O campo de FORMAÇÃO é requerido.")
	protected String formacao;
	@NotNull(message ="O campo de ATUAÇÃO é requerido.")
	protected String atuacao;
	@NotNull(message ="O campo de PRETENÇÃO é requerido.")
	protected String pretencao;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();
	
	public CandidatoDTO() {
		super();
	}
	
	public CandidatoDTO(Candidato obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.linkedin = obj.getLinkedin();
		this.formacao = obj.getFormacao();
		this.atuacao = obj.getAtuacao();
		this.pretencao = obj.getPretencao();
		this.dataCriacao = obj.getDataCriacao();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLinkedin() {
		return linkedin;
	}

	public void setLinkedin(String linkedin) {
		this.linkedin = linkedin;
	}

	public String getFormacao() {
		return formacao;
	}

	public void setFormacao(String formacao) {
		this.formacao = formacao;
	}

	public String getAtuacao() {
		return atuacao;
	}

	public void setAtuacao(String atuacao) {
		this.atuacao = atuacao;
	}

	public String getPretencao() {
		return pretencao;
	}

	public void setPretencao(String pretencao) {
		this.pretencao = pretencao;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
}
	
