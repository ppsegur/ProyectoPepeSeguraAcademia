package com.salesianostriana.dam.proyectopepesegura.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;
import com.salesianostriana.dam.proyectopepesegura.modelo.Venta;
import com.salesianostriana.dam.proyectopepesegura.servicio.EstudianteServicio;
import com.salesianostriana.dam.proyectopepesegura.servicio.VentaServicio;


@Controller
public class EstudianteController {


	@Autowired
	 public EstudianteServicio estudianteServicio;
	@Autowired
	public VentaServicio ventaServicio;
	
	@GetMapping("/admin/Estudiante")
	public String listarTodosEstudiante(Model model) {
		model.addAttribute("listaEstudiante",estudianteServicio.findAll() );
		return "admin/listaEstudiante";
	}
	@GetMapping("/admin/formularioEstudiante")
	public String mostrarFormularioEstudiante(Model model) {
		model.addAttribute("estudiante", new Estudiante());
		return "admin/formularioEstudiante";
	}
	
	@PostMapping("/admin/nuevoEstudiante/submit")
	public String procesarFormularioEstudainte(@ModelAttribute("estudiante") Estudiante e) {
		estudianteServicio.save(e);
		return "redirect:/admin/listaEstudiante";
	}
	
	@GetMapping("/admin/editarEstudiante/{id}")
	public String mostrarFormularioEdicionEstudiante(@PathVariable("id") long id, Model model) {
		Optional<Estudiante> estudianteEditar = estudianteServicio.findById(id);
		if(estudianteEditar.isPresent()) {
			model.addAttribute("estudiante", estudianteEditar.get());
			return "admin/editarFormularioEstudiante";
		}else {
			return "redirect:/admin/Estudiante";
		}
	}
	@PostMapping("/admin/editarEstudiante/submit")
	public String procesarFormularioEdicionEstudiante(@ModelAttribute("estudiante") Estudiante e) {
		estudianteServicio.save(e);
		return "redirect:/admin/Estudiante";
	}
	/**
	 * Método para borrar 
	 * @param id
	 * @return 
	 */
	@GetMapping("/admin/borrarEstudiante/{id}")
	public String borrarEstudiante(@PathVariable("id") long id) {
		Optional<Estudiante> estudiantes = estudianteServicio.findById(id);
		if(estudiantes.isPresent() && estudiantes.get().isNoEstudiante()==false){
		estudianteServicio.delete(estudiantes.get());
		}if(estudiantes.isPresent() && estudiantes.get().isNoEstudiante()==true){
			return "redirect:/admin/Estudiante?error=true";
		}
		return "redirect:/admin/Estudiante";
		
	}
	 @GetMapping("/user/nuevoEstudiante")
	    public String guardarEstudiante(Model model) {
	        model.addAttribute("estudiante", new Estudiante());
	        return "register"; 
	    }

	    @PostMapping("/user/nuevoEstudiante/submit")
	    public String register(@ModelAttribute("estudiante") Estudiante estudiante) {
	    	estudianteServicio.save(estudiante).setNoEstudiante(false);
	        return "redirect:/index";
	    }
	    
	    //Mostrar lista d eventas a usuario
	    @GetMapping("/ventas")
	    public String listarVentas(@AuthenticationPrincipal Estudiante estudiante, Model model) {
	        Optional<Venta> ventas = ventaServicio.obtenerVentasPorEstudiante(estudiante);
	        model.addAttribute("ventas", ventas);
	        return "lineaVentaUsuario"; // Aquí debes retornar el nombre de tu plantilla Thymeleaf
	    }

}