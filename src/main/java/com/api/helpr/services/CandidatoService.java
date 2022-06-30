package com.api.helpr.services;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.helpr.domain.Candidato;
import com.api.helpr.domain.dtos.CandidatoDTO;
import com.api.helpr.repositories.CandidatoRepository;

@Service
public class CandidatoService {

	@Autowired
	CandidatoRepository repository;
	
	public Candidato create(@Valid CandidatoDTO objDto) {
		objDto.setId(null);
		Candidato newObj = new Candidato(objDto);
		return repository.save(newObj);
	}
}
