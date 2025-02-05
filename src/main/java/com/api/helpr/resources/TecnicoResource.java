package com.api.helpr.resources;

import java.net.URI;
import java.time.LocalDate;
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

import com.api.helpr.domain.LogTecnicoPerfil;
import com.api.helpr.domain.LogTecnicoExclusao;
import com.api.helpr.domain.Tecnico;
import com.api.helpr.domain.dtos.TecnicoDTO;
import com.api.helpr.services.TecnicoService;

@RestController
@RequestMapping(value = "/service/tecnicos")
public class TecnicoResource {
	
	@Autowired
	private TecnicoService service;
	
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id){
		Tecnico obj = service.findById(id);
		return ResponseEntity.ok().body(new TecnicoDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<TecnicoDTO>> findAllTecnicos(){
		List<Tecnico> list = service.findAllTecnicos();
		List<TecnicoDTO> listDto = list.stream()
				.map(tec -> new TecnicoDTO(tec)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@GetMapping("/relatorio/log")
	public ResponseEntity<List<LogTecnicoPerfil>> findLogTecnicoPerfil(){
		LocalDate dataDia = LocalDate.now();
		List<LogTecnicoPerfil> list = service.findLogTecnicoPerfil(dataDia);
		return ResponseEntity.ok().body(list);
	}
	@GetMapping(value ="/usuario/{nome}")
	public ResponseEntity<List<TecnicoDTO>> findTecnico(@PathVariable String nome){
		List<Tecnico> list = service.findTecnico(nome);
		List<TecnicoDTO> listDto = list.stream()
				.map(tec -> new TecnicoDTO(tec)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PostMapping
	public ResponseEntity<TecnicoDTO> createTecnico(@Valid @RequestBody TecnicoDTO objDto){
		Tecnico newObj = service.create(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@PutMapping(value = "/{id}")
	public ResponseEntity<TecnicoDTO> updateTecnico(
			@PathVariable Integer id, @RequestBody TecnicoDTO objDto){
		Tecnico obj = service.update(id, objDto);
		return ResponseEntity.ok().body(new TecnicoDTO(obj));
	}
	
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	@DeleteMapping(value="{id}")
	public ResponseEntity<TecnicoDTO> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping(value="/log/exclusao")
	public ResponseEntity<List<LogTecnicoExclusao>> findLogTecnicoExclusao(){
		List <LogTecnicoExclusao> logList = service.findLogTecnicoExclusao();
		return ResponseEntity.ok().body(logList);
	}
	

 }
