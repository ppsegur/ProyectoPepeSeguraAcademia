package com.salesianostriana.dam.proyectopepeseguraaca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectopepeseguraaca.servicios.EstudianteServicio;

@Controller
@RequestMapping("/EstudianteAdmin")
public class EstudianteController {
	/*
	@Autowired
	EstudianteServicio estudianteServicio;
	
	/*@GetMapping({"/", "/listaEstudiante"})
	public String listarTodos(Model model) {
		model.addAttribute("lista",estudianteService.findAll() );
		return "inicioUser";
	}
	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("estudiante", new Estudiante());
		return "Formulario";
	}
	
	@PostMapping("/nuevo/submit")
	public String procesarFormulario(@ModelAttribute("estudiante") Estudiante e) {
		estudianteService.save(e);
		return "rediret:/";
	}
	
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		
		if(estudianteService.findById(id).isPresent()) {
			model.addAttribute("estudiante", estudianteService.findById(id).get());
			return "Formulario";
		}else {
			return "redirect:/";
		}
	}
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("estudiante") Estudiante e) {
		estudianteService.edit(e);
		return "redirect:/";
	}*/
	/**
	 * Método para borrar 
	 * @param id
	 * @return 
	 */
	/*@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		estudianteService.deleteById(id);
		return "redirect:/";
	}
	*/
}
