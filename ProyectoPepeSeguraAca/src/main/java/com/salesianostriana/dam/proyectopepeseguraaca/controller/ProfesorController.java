package com.salesianostriana.dam.proyectopepeseguraaca.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import com.salesianostriana.dam.proyectopepeseguraaca.model.Profesor;
import com.salesianostriana.dam.proyectopepeseguraaca.servicios.ProfesorServicio;

@Controller

public class ProfesorController {

	@Autowired
	ProfesorServicio profesorServicio;
	
	@GetMapping("/adminProfesor")
	public String listarProfesor(Model model) {
		model.addAttribute("listaProfesor",profesorServicio.findAll() );
		return "admin/listaProfesor";
	}
	@GetMapping("/adminformularioProfesor")
	public String mostrarFormularioProfesor(Model model) {
		model.addAttribute("profesor", new Profesor());
		return "admin/formularioProfesor";
	}
	
	@PostMapping("/nuevoProfesor/submit")
	public String procesarFormulario(@ModelAttribute("profesor")Profesor p) {
		profesorServicio.save(p);
		return "redirect:/adminProfesor";
	}
	
	@GetMapping("/editarProfesor/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		Optional<Profesor> profesorEditar = profesorServicio.findById(id);
		if(profesorEditar.isPresent()) {
			model.addAttribute("profesor", profesorEditar.get());
			return "admin/editarformularioProfesor";
		}else {
			return "redirect:/adminProfesor";
		}
	}
	@PostMapping("/editarProfesor/submit")
	public String procesarFormularioEdicion(@ModelAttribute("profesor")  Profesor p) {
		profesorServicio.edit(p);
		return "redirect:/adminProfesor";
	}
	
	@GetMapping("/borrarProfesor/{id}")
	public String borrar(@PathVariable("id") long id) {
		Optional<Profesor> profesorb = profesorServicio.findById(id);
		if(profesorb.isPresent()){
		profesorServicio.delete(profesorb.get());
	}
		return "redirect:/adminProfesor";
	}
}
