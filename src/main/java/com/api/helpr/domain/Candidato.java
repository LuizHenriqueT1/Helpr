package com.api.helpr.domain;

import java.time.LocalDate;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.api.helpr.domain.dtos.CandidatoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Candidato implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	protected Integer id;
	protected String nome;
	
	@Column(unique = true)
	protected String email;
	protected String linkedin;
	protected String formacao;
	protected String atuacao;
	protected String pretencao;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	protected LocalDate dataCriacao = LocalDate.now();
	
	
	public Candidato() {
		super();
	}
	
	public Candidato(Integer id, String nome, String email, String linkedin, String formacao, String atuacao, String pretencao) {
	super();
	this.id = id;
	this.nome = nome;
	this.email = email;
	this.linkedin = linkedin;
	this.formacao = formacao;
	this.atuacao = atuacao;
	this.pretencao = pretencao;
	}
	
	public Candidato(CandidatoDTO obj) {
		super();
		this.id = obj.getId();
		this.email = obj.getEmail();
		this.nome = obj.getNome();
		this.linkedin = obj.getLinkedin();
		this.atuacao = obj.getAtuacao();
		this.formacao = obj.getFormacao();
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

	public void setLinkdin(String linkedin) {
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
