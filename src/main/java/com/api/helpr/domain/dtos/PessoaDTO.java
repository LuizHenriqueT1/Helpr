package com.api.helpr.domain.dtos;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import com.api.helpr.domain.Pessoa;
import com.api.helpr.domain.enums.Perfil;

public class PessoaDTO extends Pessoa {
    
    protected Integer id;
	protected String nome;
	protected String cpf;
	protected String email;
	protected String senha;
	protected Set<Integer> perfils = new HashSet<>();

    public PessoaDTO() {
        super();
    }

    public PessoaDTO(Pessoa obj) {
        super();
        this.id = obj.getId();
        this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfils = obj.getPerfils().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Set<Perfil> getPerfils() {
        return perfils.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
    }

    public void setPerfils(Set<Integer> perfils) {
        this.perfils = perfils;
    }
}
