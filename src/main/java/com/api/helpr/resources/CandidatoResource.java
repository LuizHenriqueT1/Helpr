package com.api.helpr.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@GetMapping
	public ResponseEntity<List<CandidatoDTO>> findAllCandidatos() {
		List<Candidato> list = service.findAllCandidatos();
		List<CandidatoDTO> listDto = list.stream()
				.map(can -> new CandidatoDTO(can)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')") 
	@GetMapping(value = "/{nome}")
	public ResponseEntity<CandidatoDTO> findByNome(@PathVariable String nome) {
		Candidato obj = service.findByNome(nome);
		return ResponseEntity.ok().body(new CandidatoDTO(obj));
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')") 
	@GetMapping(value = "/id/{id}")
	public ResponseEntity<CandidatoDTO> findById(@PathVariable Integer id){
		Candidato obj = service.findById(id);
		return ResponseEntity.ok().body(new CandidatoDTO(obj));
	}

	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PostMapping
	ResponseEntity<CandidatoDTO> createCandidato(@Valid @RequestBody CandidatoDTO objDto) {
		Candidato newObj = service.create(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	 
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<CandidatoDTO> updateCandidato(
			@PathVariable Integer id, @RequestBody CandidatoDTO objDTO){
		Candidato obj = service.update(id, objDTO);
		return ResponseEntity.ok().body(new CandidatoDTO(obj));
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@DeleteMapping(value="{id}")
	public ResponseEntity<CandidatoDTO> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}