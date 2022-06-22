package com.app.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.web.entity.Monoplaza;
import com.app.web.entity.Persona;
import com.app.web.repository.MonoplazaRepository;


@Service
public class MonoplazaServiceImpl implements IMonoplazaService{

	
	@Autowired
	private MonoplazaRepository dbUtility;
	
	
	public List<Monoplaza> listAll(String equipoClave) {
		if(equipoClave != null) {
			return (List<Monoplaza>) dbUtility.findAll(equipoClave);
		}else {
			return (List<Monoplaza>) dbUtility.findAll();
		}
		
	}
	
	
	

	@Override
	public void save(Monoplaza vehiculo) {
		dbUtility.save(vehiculo);
		
	}
	@Override
	public void modify(Monoplaza vehiculo, Long id) {
		Monoplaza modificar = dbUtility.findById(id).orElse(null);
		modificar.setEquipo(vehiculo.getEquipo());
		modificar.setModelo(vehiculo.getModelo());
		modificar.setId(vehiculo.getId());
		save(modificar);
	}

	@Override
	public void asignacion(Persona corredor, Long id) {
		Monoplaza asignar = dbUtility.findById(id).orElse(null);
		asignar.setCorredor(corredor);
		asignar.setId(asignar.getId());
		save(asignar);
	}
	@Override
	public Monoplaza findById(Long id) {
		return dbUtility.findById(id).orElse(null);
	}

	@Override
	public void delete(Long id) {
		dbUtility.deleteById(id);
		
	}

	


}
