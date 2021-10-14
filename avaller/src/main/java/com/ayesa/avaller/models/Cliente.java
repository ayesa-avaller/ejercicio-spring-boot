package com.ayesa.avaller.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;
import lombok.NonNull;

@Data
@Entity
public class Cliente {
	@Id
	@Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String nombre;
	
	private String tlf;
	public Cliente() {
		this.id = 0L;
		this.nombre = "";
		this.tlf = "";
	}
	public Cliente(Long id, String nombre, String tlf) {
		this.id = id;
		this.nombre = nombre;
		this.tlf = tlf;
	}
	
	
	
	
}
