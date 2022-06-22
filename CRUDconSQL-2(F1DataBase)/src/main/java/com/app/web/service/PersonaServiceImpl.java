package com.app.web.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entity.Persona;
import com.app.web.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements IPersonaService{

	@Autowired
	private PersonaRepository dbUtility;
	

	public List<Persona> listAll(boolean victory) {
		if(victory) {
			return (List<Persona>) dbUtility.findAll(victory);
		}else if(!victory){
			return (List<Persona>) dbUtility.findAll(!victory);
		} else {
			return (List<Persona>) dbUtility.findAll();
		}
		
	}

	@Override
	public void save(Persona usuario) {
		dbUtility.save(usuario);
		
	}

	@Override
	public Persona findById(Long id) {
		return dbUtility.findById(id).orElse(null);
	}

	@Override
	public void modify(Long id, Persona persona) {
		Persona modificar = dbUtility.findById(id).orElse(null);
		modificar.setNombre(persona.getNombre());
		modificar.setApellido(persona.getApellido());
		modificar.setVictorias(persona.isVictorias());
		modificar.setId(persona.getId());
		save(modificar);
		
	}
	
	@Override
	public void delete(Long id) {
		dbUtility.deleteById(id);
		
	}



}
