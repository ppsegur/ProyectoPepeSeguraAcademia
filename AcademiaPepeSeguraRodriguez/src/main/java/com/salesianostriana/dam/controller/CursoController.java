package com.salesianostriana.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.salesianostriana.dam.model.Curso;
import com.salesianostriana.dam.model.Estudiante;
import com.salesianostriana.dam.services.CursoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/admin/curso")
public class CursoController {
	@Autowired
	 CursoService cursoService;
	
	public CursoController(CursoService cursoService) {
		this.cursoService = cursoService;
	}
	
	@GetMapping({"/", "/listaCurso"})
	public String getMethodName(Model model) {
		model.addAttribute("listaCurso", cursoService.findAll() );
		return "list-Curso";
	}
	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("curso", new Curso());
		return "FormularioCurso";
	}
	@PostMapping("/nuevo/submit")
	public String procesarFormulario(@ModelAttribute("curso") Curso c) {
		cursoService.save(c);
		return "rediret:/";
	}
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		
		if(cursoService.findById(id).isPresent()) {
			model.addAttribute("curso", cursoService.findById(id).get());
			return "FormularioCurso";
		}else {
			return "redirect:/";
		}
	}

	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("curso") Curso c) {
		cursoService.edit(c);
		return "redirect:/";
	}
	/**
	 * Método para borrar 
	 * @param id
	 * @return 
	 */
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		cursoService.deleteById(id);
		return "redirect:/";
	}
	
	
}
