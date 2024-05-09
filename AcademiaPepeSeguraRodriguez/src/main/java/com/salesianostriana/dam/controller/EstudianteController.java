package com.salesianostriana.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.model.Estudiante;
import com.salesianostriana.dam.services.EstudianteService;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;




@Controller
@RequestMapping("admin/estudiante")
public class EstudianteController {

	@Autowired
	EstudianteService estudianteService;
	public EstudianteController(EstudianteService servicio) {
		this.estudianteService = servicio;
	}
	
	@GetMapping({"/", "listaEstudiante"})
	public String listarTodos(Model model) {
		model.addAttribute("lista",estudianteService.findAll() );
		return "listaDeEstudiantes";//No colocada
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
	}
	/**
	 * Método para borrar 
	 * @param id
	 * @return 
	 */
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		estudianteService.deleteById(id);
		return "redirect:/";
	}
	
	 
	
	
}
