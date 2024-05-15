package com.salesianostriana.dam.proyectopepeseguraaca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectopepeseguraaca.servicios.ProfesorServicio;

@Controller
@RequestMapping("/ProfesorAdmin")
public class ProfesorController {
/*
	@Autowired
	ProfesorServicio profesorServicio;
	
	/*@GetMapping({"/", "/listaProfesor"})
	public String listarTodos(Model model) {
		model.addAttribute("lista",profesorServicio.findAll() );
		return "listaDeProfesores";//No colocada
	}
	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("profesor", new Profesor());
		return "FormularioProfesor";
	}
	
	@PostMapping("/nuevo/submit")
	public String procesarFormulario(@ModelAttribute("profesor")Profesor p) {
		profesorServicio.save(p);
		return "rediret:/";
	}
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		
		if(profesorServicio.findById(id).isPresent()) {
			model.addAttribute("estudiante", profesorServicio.findById(id).get());
			return "FormularioProfesor";
		}else {
			return "redirect:/";
		}
	}
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("profesor")  Profesor p) {
		profesorServicio.edit(p);
		return "redirect:/";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		profesorServicio.deleteById(id);
		return "redirect:/";
	}*/
}
