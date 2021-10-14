package com.ayesa.avaller.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayesa.avaller.dtos.ClienteEnviado;
import com.ayesa.avaller.models.Cliente;
import com.ayesa.avaller.repositories.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository repository;
	
	public List<Cliente> findAll() {
		return repository.findAll();
	}
	
	public Optional<Cliente> findById(Long id){
		return repository.findById(id);
	}

	public Cliente getById(Long id) {
		return repository.findById(id).get();
	}

	public Cliente save(ClienteEnviado cliente) {
		Cliente ret = new Cliente(null,cliente.getNombre(),cliente.getTlf());
		repository.save(ret);
		return ret;
	}

	public void deleteById(Long id) {
		repository.deleteById(id);
	}
	
	public Cliente update(Cliente cliente) {
        return repository.save(cliente);
    }
}
