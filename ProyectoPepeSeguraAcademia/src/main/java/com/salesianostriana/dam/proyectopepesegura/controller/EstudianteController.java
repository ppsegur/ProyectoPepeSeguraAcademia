package com.salesianostriana.dam.proyectopepesegura.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.PasswordEncoderParser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectopepesegura.modelo.Curso;
import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;
import com.salesianostriana.dam.proyectopepesegura.modelo.Venta;
import com.salesianostriana.dam.proyectopepesegura.security.PasswordEncoderConfig;
import com.salesianostriana.dam.proyectopepesegura.servicio.CursoServicio;
import com.salesianostriana.dam.proyectopepesegura.servicio.EstudianteServicio;
import com.salesianostriana.dam.proyectopepesegura.servicio.VentaServicio;


@Controller
public class EstudianteController {


	@Autowired
	 public EstudianteServicio estudianteServicio;
	@Autowired
	public VentaServicio ventaServicio;
	@Autowired
	public CursoServicio cursoServicio;
	
	@GetMapping("/indexEstudiante")
	public String index() {
		return "index";
	}
	//Controlador para qeu el administrador pueda ver la lista de estudiantes o usuarios 
	@GetMapping("/admin/Estudiante")
	public String listarTodosEstudiante(Model model) {
		model.addAttribute("listaEstudiante",estudianteServicio.findAll() );
		return "admin/listaEstudiante";
	}
	//Controlador deprecateD para añadir un estudiante
	@GetMapping("/admin/formularioEstudiante")
	public String mostrarFormularioEstudiante(Model model) {
		model.addAttribute("estudiante", new Estudiante());
		return "admin/formularioEstudiante";
	}
	//Procesar el anterior método
	@PostMapping("/admin/nuevoEstudiante/submit")
	public String procesarFormularioEstudainte(@ModelAttribute("estudiante") Estudiante e) {
	
		estudianteServicio.save(e);
		
		return "redirect:/admin/listaEstudiante";
	}
	
	/**
	 * @deprecated
	 * @param e
	 * @param model
	 * @return
	 */
	@GetMapping("/user/editarFormularioEstudiante")
	public String mostrarFormularioEdicionEstudiante(@AuthenticationPrincipal Estudiante e, Model model) {
			model.addAttribute("estudiante", e);
	
			return "editarFormularioEstudiante";
		}
	
	/***
	 * 
	 * @deprecated
	 */@PostMapping("/user/editarFormularioEstudiante/submit")
	public String procesarFormularioEdicionEstudiante(@ModelAttribute("estudiante") Estudiante e) {

	e.setPassword(e.getPassword());
		estudianteServicio.save(e);
		return "redirect:/indexEstudiante";
	}
	//Controlador para borra estudiante con modal(y con error)
	@GetMapping("/admin/borrarEstudiante/{id}")
	public String borrarEstudiante(@PathVariable("id") long id) {
	    Optional<Estudiante> estudiante = estudianteServicio.findById(id);
	    if (estudiante.isPresent()) {
	        if (estudiante.get().isNoEstudiante()) {
	            return "redirect:/admin/Estudiante?error=true";
	        } else {
	            estudianteServicio.delete(estudiante.get());
	        }
	    }
	    return "redirect:/admin/Estudiante";
	}
	//COntrolador para el registro
	 @GetMapping("/user/nuevoEstudiante")
	    public String guardarEstudiante(Model model) {
	        model.addAttribute("estudiante", new Estudiante());
	        return "register"; 
	    }
	 //controlador para procesar el anterior
	    @PostMapping("/user/nuevoEstudiante/submit")
	    public String register(@ModelAttribute("estudiante") Estudiante estudiante) {
	    	estudianteServicio.save(estudiante).setNoEstudiante(false);
	        return "redirect:/index";
	    }
	    
	    //Controlador para listar ventas
	    @GetMapping("/ventas")
	    public String listarVentas(@AuthenticationPrincipal Estudiante estudiante, Model model) {
	    	List<Venta> ventas = ventaServicio.obtenerTodasLasVentas(estudiante);
	        if (!ventas.isEmpty()) {
	            model.addAttribute("ventas", ventas);
	        }
	        return "lineaVentaUsuario";
	    }
	    
	    //Métodos para FAVORITOS
	    @GetMapping("/user/cursofav")
	    public String listarCursosFavoritos(@AuthenticationPrincipal Estudiante e, 
	                              Model model) {
	        model.addAttribute("listaFav",e.getCursosFavoritos());
	        return "listaFav";
		}
	    @PostMapping("/agregarFavorito/{idCurso}")
	    public String agregarFavorito(@AuthenticationPrincipal Estudiante e, @PathVariable("idCurso") long cursoId) {

	        Optional<Curso> curso = cursoServicio.findById(cursoId);
	        estudianteServicio.save(e);
	        if (curso.isPresent()) {
	          if(e.getCursosFavoritos().contains(curso.get())) {
	        	  	return "redirect:/user/cursofav";
	          }else{
	        	  e.getCursosFavoritos().add(curso.get());
	        	  estudianteServicio.edit(e);
	          }
	            
	        }
	        return "redirect:/user/cursofav";
	    }
	    
	    @PostMapping("/eliminarFavorito/{cursoId}")
	    public String eliminarFavorito(@AuthenticationPrincipal Estudiante e, @PathVariable("cursoId") long cursoId) {
	        
	        Optional<Curso> curso = cursoServicio.findById(cursoId);
	        if (curso.isPresent()) {
	        	if(e.getCursosFavoritos().contains(curso.get())) {
	        		 e.getCursosFavoritos().remove(curso.get());
	 	            estudianteServicio.save(e);
	        	}
	           
	        }
	        return "redirect:/user/cursofav";
	    }
	    
	  
	}


