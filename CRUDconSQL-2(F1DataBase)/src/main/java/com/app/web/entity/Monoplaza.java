package com.app.web.entity;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;


import lombok.*;



@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "monoplaza")
public class Monoplaza implements Serializable{

	
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	@Column(name = "equipo")
	private String equipo;
	
	@Column(name = "modelo")
	private String modelo;
	
	@OneToOne(targetEntity = Persona.class)
	@JoinColumn(name = "nombre")
	public Persona corredor;

	
	
	
	public Monoplaza(String equipo, String modelo) {
		this.equipo = equipo;
		this.modelo = modelo;
		this.corredor = null;
	}

	
	
	public Monoplaza() {
		this.corredor = null;
	}




	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEquipo() {
		return equipo;
	}

	public void setEquipo(String equipo) {
		this.equipo = equipo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	
	
	
}
