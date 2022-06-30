package com.api.helpr.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import com.api.helpr.domain.ClienteFuturo;
import com.fasterxml.jackson.annotation.JsonFormat;

public class ClienteFuturoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	@NotNull(message = "O campo NOME não poderá ser nulo")
	private String nome;
	@NotNull(message = "O campo EMAIL não poderá ser nulo")
	private String email;
	@NotNull(message = "O campo TELEFONE não poderá ser nulo")
	private String telefone;

	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCriacao = LocalDate.now();

	public ClienteFuturoDTO(ClienteFuturo obj)
	 {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.telefone = obj.getTelefone();
		this.dataCriacao = obj.getDataCriacao();
	}

	public ClienteFuturoDTO() {
		super();
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
