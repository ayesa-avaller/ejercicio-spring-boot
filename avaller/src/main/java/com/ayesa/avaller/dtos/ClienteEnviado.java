package com.ayesa.avaller.dtos;

import com.ayesa.avaller.models.Cliente;

import lombok.Data;
import lombok.NonNull;

@Data
public class ClienteEnviado {
	@NonNull
	private String nombre;
	@NonNull
	private String tlf;
	
	public ClienteEnviado() {
	}
	
	public ClienteEnviado(@NonNull String nombre, @NonNull String tlf) {
		this.nombre = nombre;
		this.tlf = tlf;
	}
	
	
}
