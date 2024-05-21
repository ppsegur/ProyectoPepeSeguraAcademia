package com.salesianostriana.dam.proyectopepesegura.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;
import com.salesianostriana.dam.proyectopepesegura.servicio.EstudianteServicio;

@Controller
@RequestMapping("/admin")
public class EstudianteController {


	@Autowired
	 public EstudianteServicio estudianteServicio;
	
	@GetMapping("/adminEstudiante")
	public String listarTodosEstudiante(Model model) {
		model.addAttribute("listaEstudiante",estudianteServicio.findAll() );
		return "admin/listaEstudiante";
	}
	@GetMapping("/adminformularioEstudiante")
	public String mostrarFormularioEstudiante(Model model) {
		model.addAttribute("estudiante", new Estudiante());
		return "admin/formularioEstudiante";
	}
	
	@PostMapping("/nuevoEstudiante/submit")
	public String procesarFormularioEstudainte(@ModelAttribute("estudiante") Estudiante e) {
		estudianteServicio.save(e);
		return "redirect:/adminEstudiante";
	}
	
	@GetMapping("/editarEstudiante/{id}")
	public String mostrarFormularioEdicionEstudiante(@PathVariable("id") long id, Model model) {
		Optional<Estudiante> estudianteEditar = estudianteServicio.findById(id);
		if(estudianteEditar.isPresent()) {
			model.addAttribute("estudiante", estudianteEditar.get());
			return "admin/editarFormularioEstudiante";
		}else {
			return "redirect:/adminEstudiante";
		}
	}
	@PostMapping("/editarEstudiante/submit")
	public String procesarFormularioEdicionEstudiante(@ModelAttribute("estudiante") Estudiante e) {
		estudianteServicio.save(e);
		return "redirect:/adminEstudiante";
	}
	/**
	 * Método para borrar 
	 * @param id
	 * @return 
	 */
	@GetMapping("/borrarEstudiante/{id}")
	public String borrarEstudiante(@PathVariable("id") long id) {
		Optional<Estudiante> estudiantes = estudianteServicio.findById(id);
		if(estudiantes.isPresent()){
		estudianteServicio.delete(estudiantes.get());
		}
		return "redirect:/adminEstudiante";
		
	}
}
