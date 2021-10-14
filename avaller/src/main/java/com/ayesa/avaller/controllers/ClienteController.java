package com.ayesa.avaller.controllers;

import java.util.List;
import java.util.NoSuchElementException;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ayesa.avaller.dtos.ClienteDevueltoDTO;
import com.ayesa.avaller.dtos.ClienteEnviado;
import com.ayesa.avaller.dtos.ClienteListDTO;
import com.ayesa.avaller.models.Cliente;
import com.ayesa.avaller.services.ClienteService;

@RestController
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@GetMapping("/api/clientes")
	public ClienteListDTO getAll() {
		List<Cliente> listado = service.findAll();
		if(listado == null) {
			return new ClienteListDTO(true, null, "No se ha podido acceder a los datos.");
		}
		return new ClienteListDTO(false, listado, "");
	}
	
	@PostMapping("/api/clientes")
	public ClienteDevueltoDTO postClientes(@RequestBody @Valid ClienteEnviado cliente) {
		Cliente ret = service.save(cliente);
		if(ret == null) {
			return new ClienteDevueltoDTO(true, null, "Error al añadir.");
		} else {
			return new ClienteDevueltoDTO(false, ret, "");
		}
	}
	
	@GetMapping("/api/clientes/{id}")
	public ClienteDevueltoDTO getUnCliente(@PathVariable Long id) {
		try{
			Cliente ret = service.getById(id);
			return new ClienteDevueltoDTO(false, ret, "");
		} catch(NoSuchElementException e) {
			return new ClienteDevueltoDTO(true, null, "No se pudo encontrar.");
		}
	}
	
	@PutMapping("/api/clientes/{id}")
	public ClienteDevueltoDTO putById(@PathVariable Long id, @RequestBody @Valid Cliente cliente) {
		try {
			Cliente ret = service.getById(id);
			ret.setNombre(cliente.getNombre());
			ret.setTlf(cliente.getTlf());
			service.update(ret);
			return new ClienteDevueltoDTO(false, ret, "");
		} catch(NoSuchElementException e) {
			return new ClienteDevueltoDTO(false, null, "No se pudo actualizar");
		}
	}
	
	@DeleteMapping("/api/clientes/{id}")
	public ClienteDevueltoDTO deleteCliente(@PathVariable Long id) {
		try {
			Cliente ret = service.getById(id);
			service.deleteById(id);
			return new ClienteDevueltoDTO(false, ret, "");
		} catch(NoSuchElementException e) {
			return new ClienteDevueltoDTO(true, null, "No se pudo encontrar.");
		}
	}
}
