package com.api.helpr.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.helpr.domain.Candidato;
import com.api.helpr.domain.dtos.CandidatoDTO;
import com.api.helpr.repositories.CandidatoRepository;
import com.api.helpr.services.exceptions.ObjectNotFoundException;

@Service
public class CandidatoService {

	@Autowired
	CandidatoRepository repository;

	public Candidato create(@Valid CandidatoDTO objDto) {
		objDto.setId(null);
		Candidato newObj = new Candidato(objDto);
		return repository.save(newObj);
	}

	public Candidato findByNome(String nome) {
		Optional<Candidato> obj = repository.findByNome(nome);
		return obj.orElseThrow(() -> new ObjectNotFoundException(nome + ": não foi encontrado"));
	}

	public List<Candidato> findAllCandidatos() {
		return repository.findAll();
	}
}