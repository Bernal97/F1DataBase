package com.app.web.service;

import java.util.List;

import com.app.web.entity.Persona;


public interface IPersonaService {
	public List<Persona> listAll(boolean victory);
	
	public void save(Persona usuario);
	
	public Persona findById(Long id);
	
	public void modify(Long id, Persona persona);
	
	public void delete(Long id);
}
