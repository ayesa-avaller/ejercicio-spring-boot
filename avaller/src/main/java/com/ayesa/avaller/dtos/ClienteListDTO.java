package com.ayesa.avaller.dtos;

import java.util.List;

import com.ayesa.avaller.models.Cliente;

import lombok.Data;

@Data
public class ClienteListDTO {
	private boolean errors;
	private List<Cliente> clientes;
	private String message;
	
	public ClienteListDTO(boolean errors, List<Cliente> clientes, String message) {
		this.errors = errors;
		this.clientes = clientes;
		this.message = message;
	}
	
}
