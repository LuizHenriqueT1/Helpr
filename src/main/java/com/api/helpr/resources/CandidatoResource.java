package com.api.helpr.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.helpr.domain.Candidato;
import com.api.helpr.domain.dtos.CandidatoDTO;
import com.api.helpr.services.CandidatoService;

@RestController
@RequestMapping(value = "/service/candidatos")
public class CandidatoResource {

	@Autowired
	private CandidatoService service;

	
	@GetMapping(value = "/{nome}")
	public ResponseEntity<CandidatoDTO> findByNome(@PathVariable String nome) {
		Candidato obj = service.findByNome(nome);
		return ResponseEntity.ok().body(new CandidatoDTO(obj));
	}

	@PostMapping
	ResponseEntity<CandidatoDTO> createCandidato(@Valid @RequestBody CandidatoDTO objDto) {
		Candidato newObj = service.create(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
}