package com.api.helpr.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.helpr.domain.Pessoa;
import com.api.helpr.repositories.PessoaRepository;
import com.api.helpr.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {
    
    @Autowired
    private PessoaRepository pessoaRepository;

    public Pessoa findByEmail(String email) {
        Optional<Pessoa> obj = pessoaRepository.findByEmail(email);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não foi encontrado: " + email));
    }
}
