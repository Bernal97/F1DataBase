package com.app.web.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.springframework.lang.NonNull;

import lombok.*;

@AllArgsConstructor
@Data
@Getter
@Entity
@Table (name = "persona")
public class Persona implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;
	
	@NonNull
	@Column(name = "nombre")
	public String nombre;
	
	@NonNull
	@Column(name = "apellido")
	public String apellido;
	
	@NonNull
	@Column(name = "victorias")
	public boolean victorias;
	
	@OneToOne(cascade=CascadeType.ALL, targetEntity = Monoplaza.class)
	@JoinColumn(name = "equipo")
	public Monoplaza vehiculo;
	 
	
	public Persona() {
		super();
		this.victorias = false;
		this.vehiculo = null;
	}
	public Persona(String nombre, String apellido, boolean victorias) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.victorias = victorias;
		this.vehiculo = null;
	}
	
	
	
	
	
	public boolean isVictorias() {
		return victorias;
	}
	public void setVictorias(boolean victorias) {
		this.victorias = victorias;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Monoplaza getVehiculo() {
		return vehiculo;
	}
	public void setVehiculo(Monoplaza vehiculo) {
		this.vehiculo = vehiculo;
	}
	
	
}
