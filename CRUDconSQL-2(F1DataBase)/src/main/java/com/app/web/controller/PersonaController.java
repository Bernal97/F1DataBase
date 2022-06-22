package com.app.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.app.web.entity.Monoplaza;
import com.app.web.entity.Persona;
import com.app.web.service.IMonoplazaService;
import com.app.web.service.IPersonaService;

@Controller
@RequestMapping("/views/corredores")
public class PersonaController {

	@Autowired
	private IPersonaService dbUtility;

	@Autowired
	private IMonoplazaService dbMonoplaza;

	private List<Monoplaza> modelosList;

	@GetMapping("/")
	public String listUsuarios(Model modelo, boolean victory) {
		List<Persona> listadoUsuarios = dbUtility.listAll(victory);
		modelo.addAttribute("Titulo", "Listado Corredores");
		modelo.addAttribute("Persona", listadoUsuarios);
		modelo.addAttribute("Victoria", victory);
		return "/views/corredores/listarUsuarios";
	}

	@GetMapping("/asignar/{id}")
	public String asignarMonoplaza(@PathVariable(name = "id") Long id, Model modelo, String val) {
		Persona persona = dbUtility.findById(id);
		
		modelosList = dbMonoplaza.listAll(val);
		Monoplaza auto = new Monoplaza();
		modelo.addAttribute("Persona", persona);
		modelo.addAttribute("Monoplaza", auto);
		modelo.addAttribute("Monoplaza", modelosList);
		return "/views/corredores/monoplazaAsign";
	}

	@GetMapping("/create")
	public String create(Model modelo) {
		Persona usuario = new Persona();
		modelo.addAttribute("Titulo", "Crear Usuario");
		modelo.addAttribute("Persona", usuario);
		return "views/corredores/formUsuario";
	}

	@PostMapping("/save/{id}")
	public String save(@Validated @ModelAttribute Persona usuario) {

		dbUtility.modify(usuario.getId(), usuario);

		return "redirect:/views/corredores/";
	}

	@PostMapping("/save")
	public String saveNew(@Validated @ModelAttribute Persona usuario) {
		dbUtility.save(usuario);
		return "redirect:/views/corredores/";
	}

	
	
	@GetMapping("/editar/{id}")
	public String editarUsuario(@PathVariable(name = "id") Long id, Model modelo) {

		Persona persona = dbUtility.findById(id);
		modelo.addAttribute("Persona", persona);

		return "/views/corredores/editUsuario";
	}

	@GetMapping("/eliminar/{id}")
	public String eliminarUsuario(@PathVariable(name = "id") Long id) {
		dbUtility.delete(id);
		return "redirect:/views/corredores/";
	}

}
