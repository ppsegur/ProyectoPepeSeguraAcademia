package com.salesianostriana.dam.proyectopepesegura.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectopepesegura.modelo.Curso;
import com.salesianostriana.dam.proyectopepesegura.servicio.CursoServicio;

@Controller
public class CursoController {

	@Autowired
	CursoServicio cursoServicio;
	
	@GetMapping("/admin/Curso")
	public String listarCursos(Model model) {
		model.addAttribute("listaCurso", cursoServicio.findAll() );
		return "admin/listaCurso";
	}//mostrar formulario
	@GetMapping("/admin/formularioCurso")
	public String mostrarFormularioCurso(Model model) {
		model.addAttribute("curso", new Curso());
		return "admin/formularioCurso";
	}
	@PostMapping("/admin/nuevoCurso/submit")
	public String procesarFormularioCurso(@ModelAttribute("curso") Curso c) {
		cursoServicio.save(c);
		return "redirect:/admin/Curso";
	}
	@GetMapping("/admin/editarCurso/{idCurso}")
	public String mostrarFormularioEdicionCurso(@PathVariable("idCurso") long idCurso, Model model) {
		Optional<Curso> cursoEditar = cursoServicio.findById(idCurso);
		if(cursoEditar.isPresent()) {
			model.addAttribute("curso", cursoEditar.get());
			return "admin/editarFormularioCurso";
		}else {
			return "redirect:/admin/Curso";
		}
	}

	@PostMapping("/admin/editarCurso/submit")
	public String procesarFormularioEdicion(@ModelAttribute("curso") Curso c) {
		cursoServicio.save(c);
		return "redirect:/admin/Curso";
	}
	//Borrar curso
	@GetMapping("/admin/borrarCurso/{idCurso}")
	public String borrar(@PathVariable("idCurso") long idCurso) {
	Optional<Curso> curso = cursoServicio.findById(idCurso);
	    if(curso.isPresent()) {
	        cursoServicio.delete(curso.get());
	    }
	    return "redirect:/admin/Curso";
	}
	
	//Controladores del usuario
	//Obtener todos los cursos e ingles y mostrarselo al usuario 
	    @GetMapping("/cursos/ingles")
	    public String listarCursosDeIngles(Model model) {
	        List<Curso> cursos = cursoServicio.obtenerCursosDeIngles();
	        model.addAttribute("listaCurso", cursos);
	        return "cursosEstudiantes";
	    }
}
