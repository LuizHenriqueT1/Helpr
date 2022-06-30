package com.api.helpr.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.helpr.domain.ClienteFuturo;
import com.api.helpr.domain.dtos.ClienteFuturoDTO;
import com.api.helpr.repositories.ClienteFuturoRepository;
import com.api.helpr.services.exceptions.DataIntegrityViolationException;
import com.api.helpr.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteFuturoService {

	@Autowired
	private ClienteFuturoRepository repository;
	
	public ClienteFuturo findById(Integer id) {
		Optional<ClienteFuturo> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não foi encontrado: " + id));
	}

	public List<ClienteFuturo> findAllClientesFuturos() {
		return repository.findAll();
	}

	public ClienteFuturo create(ClienteFuturoDTO objDto) {
		objDto.setId(null);
		validaEmail(objDto);
		ClienteFuturo newObj = new ClienteFuturo(objDto);
		return repository.save(newObj);
	}
	
	private void validaEmail(ClienteFuturoDTO objDto) {

		Optional<ClienteFuturo> obj = repository.findByEmail(objDto.getEmail());
		if (obj.isPresent() && obj.get().getId() != objDto.getId()) {
			throw new DataIntegrityViolationException("E-mail já cadastrado no sistema!");
		}
	}

	public ClienteFuturo update(Integer id, ClienteFuturoDTO objDto) {
		objDto.setId(id);
		ClienteFuturo oldObj = findById(id);
		validaEmail(objDto);
		oldObj = new ClienteFuturo(objDto);
		return repository.save(oldObj);
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);		
	}
}
