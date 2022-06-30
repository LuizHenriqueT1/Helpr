package com.api.helpr.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.helpr.domain.ClienteFuturo;
import com.api.helpr.domain.dtos.ClienteFuturoDTO;
import com.api.helpr.services.ClienteFuturoService;

@RestController
@RequestMapping(value = "/service/clientes-futuros")
public class ClienteFuturoResource {

	@Autowired
	private ClienteFuturoService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<ClienteFuturoDTO> findById(@PathVariable Integer id){
		ClienteFuturo obj = service.findById(id);
		return ResponseEntity.ok().body(new ClienteFuturoDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<ClienteFuturoDTO>> findAllClientesFuturos(){
		List<ClienteFuturo> list = service.findAllClientesFuturos();
		List<ClienteFuturoDTO> listDto = list.stream()
				.map(cli -> new ClienteFuturoDTO(cli)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@PostMapping
	public ResponseEntity<ClienteFuturoDTO> createClienteFuturo(@Valid @RequestBody ClienteFuturoDTO objDto){
		ClienteFuturo newObj = service.create(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<ClienteFuturoDTO> updateClienteFuturo(
			@PathVariable Integer id, @RequestBody ClienteFuturoDTO objDto){
		ClienteFuturo obj = service.update(id, objDto);
		return ResponseEntity.ok().body(new ClienteFuturoDTO(obj));
	}
	
	@DeleteMapping(value="{id}")
	public ResponseEntity<ClienteFuturoDTO> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
