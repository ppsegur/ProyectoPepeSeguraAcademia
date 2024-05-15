package com.salesianostriana.dam.proyectopepeseguraaca.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectopepeseguraaca.model.Curso;
import com.salesianostriana.dam.proyectopepeseguraaca.model.Material;
import com.salesianostriana.dam.proyectopepeseguraaca.servicios.CursoServicio;



@Controller
public class CursoController {

	@Autowired
	CursoServicio cursoServicio;
	
	@GetMapping("/adminCurso")
	public String listarCursos(Model model) {
		model.addAttribute("listaCurso", cursoServicio.findAll() );
		return "admin/listaCurso";
	}//mostrar formulario
	@GetMapping("/adminformularioCurso")
	public String mostrarFormularioCurso(Model model) {
		model.addAttribute("curso", new Curso());
		return "admin/formularioCurso";
	}
	@PostMapping("/nuevoCurso/submit")
	public String procesarFormulario(@ModelAttribute("curso") Curso c) {
		cursoServicio.save(c);
		return "redirect:/adminCurso";
	}
	@GetMapping("/editarCurso/{idCurso}")
	public String mostrarFormularioEdicionCurso(@PathVariable("idCurso") long idCurso, Model model) {
		Optional<Curso> cursoEditar = cursoServicio.findById(idCurso);
		if(cursoEditar.isPresent()) {
			model.addAttribute("curso", cursoEditar.get());
			return "admin/editarFormularioCurso";
		}else {
			return "redirect:/adminCurso";
		}
	}

	@PostMapping("/editarCurso/submit")
	public String procesarFormularioEdicion(@ModelAttribute("curso") Curso c) {
		cursoServicio.save(c);
		return "redirect:/adminCurso";
	}
	//Borrar curso
	@GetMapping("/borrarCurso/{idCurso}")
	public String borrar(@PathVariable("idCurso") long idCurso) {
	Optional<Curso> curso = cursoServicio.findById(idCurso);
	    if(curso.isPresent()) {
	        cursoServicio.delete(curso.get());
	    }
	    return "redirect:/adminCurso";
	}
}
