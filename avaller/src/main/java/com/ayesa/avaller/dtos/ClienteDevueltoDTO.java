package com.ayesa.avaller.dtos;

import com.ayesa.avaller.models.Cliente;

import lombok.Data;

@Data
public class ClienteDevueltoDTO {
	private boolean errors;
	private Cliente cliente;
	private String message;
	
	public ClienteDevueltoDTO(boolean errors, Cliente cliente, String message) {
		this.errors = errors;
		this.cliente = cliente;
		this.message = message;
	}
}
