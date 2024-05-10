package com.salesianostriana.dam.proyectopepeseguraaca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectopepeseguraaca.servicios.CursoServicio;

@Controller
@RequestMapping("/CursosAdmin")
public class CursoController {
/*
	@Autowired
	CursoServicio cursoServicio;
	/*
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
	
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		cursoService.deleteById(id);
		return "redirect:/";
	}*/
}
