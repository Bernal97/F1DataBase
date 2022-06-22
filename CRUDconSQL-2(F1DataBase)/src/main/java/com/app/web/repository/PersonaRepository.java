package com.app.web.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.app.web.entity.Persona;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {

	
	//Lo deje asi para mas adelante encontrar una forma de usar valores arbitrarios
	@Query("SELECT e FROM Persona e WHERE e.victorias = 1 OR e.victorias = 0")
	public List<Persona> findAll(Boolean equipoClave);
}
