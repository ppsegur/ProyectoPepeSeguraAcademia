package com.salesianostriana.dam.proyectopepesegura.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.salesianostriana.dam.proyectopepesegura.modelo.Curso;
import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;
import com.salesianostriana.dam.proyectopepesegura.modelo.Venta;
import com.salesianostriana.dam.proyectopepesegura.servicio.CarritoServicio;
import com.salesianostriana.dam.proyectopepesegura.servicio.CursoServicio;
import com.salesianostriana.dam.proyectopepesegura.servicio.VentaServicio;

@Controller
@RequestMapping("/carrito")
public class CarritoControlador {

	@Autowired
	private CarritoServicio carritoServicio;

	@Autowired
	private CursoServicio cursoServicio;
	
	@Autowired
	private VentaServicio ventaServicio;


	//Controller para mostrarCarrito
	@GetMapping()
	public String mostrarCarrito(@AuthenticationPrincipal Estudiante e, Model model) {
	    if (carritoServicio.hayCarritoCreado(e)) {
	        model.addAttribute("curso", carritoServicio.getProductosEnCarrito(e));
	        model.addAttribute("carritoVacio", false);
	    } else {
	        model.addAttribute("carritoVacio", true);
	    }
	    return "carrito";
	}

		
	//Controller para añadirProducto
	// Controller para añadirProducto
	@PostMapping("/agregarCurso/{idCurso}")
	public String añadirProducto(@AuthenticationPrincipal Estudiante e,
	        @PathVariable("idCurso") Long idProducto, Model model) {

	    Optional<Curso> curso = cursoServicio.findById(idProducto);

	    if (curso.isPresent()) {
	        carritoServicio.addProducto(e, curso.get(), 1);
	        return "redirect:/carrito";
	    }
	    return "redirect:/index";
	}
		
	//Controller para finalizar compra

		@PostMapping ("/checkout")
		public String finalizarCompra(@AuthenticationPrincipal Estudiante e) {
			carritoServicio.finalizarCompra(e);
			return "index";
		}

	//Controller para eliminar producto

		@PostMapping ("/eliminarProducto/{idCurso}")
		public String eliminarProducto (@AuthenticationPrincipal Estudiante e,
				@PathVariable("idCurso") Long idProducto) {
			
			Optional <Curso> producto = cursoServicio.findById(idProducto);
			
			if(producto.isPresent()) {
				carritoServicio.eliminarCurso(e, producto.get());
				return "redirect:/carrito";
			}
			return "redirect:/cursosEstudiantes";
		}
		//Mostrar lista d eventas a usuario
	  
}
	/*
	 @PostMapping("/agregar") public String agregarCurso(@RequestParam Curso
	 curso, @AuthenticationPrincipal Estudiante estudiante) {
	  
	 if(curso !=null && estudiante !=null) {
	 carritoServicio.agregarCurso(estudiante, curso); return "redirect:/carrito";
	  } return "redirect:/index";
	  
	  
	 }
	 /*
	@GetMapping
	public String verCarrito(@AuthenticationPrincipal Estudiante estudiante, Model model) {
		Venta carrito = carritoServicio.obtenerCarrito(estudiante);
		model.addAttribute("carrito", carrito);
		return "carrito";
	}
	 //*
	@PostMapping("/agregar")
	public String agregarCurso( @AuthenticationPrincipal Estudiante estudiante, @RequestParam("idCurso") Long cursoId,
			Model model) {
// Buscar estudiante y curso por sus IDs
		Estudiante estudiante = estudianteRepositorio.findById(estudianteId).orElse(null);
		Curso curso = cursoRepositorio.findById(cursoId).orElse(null);

		if (estudiante != null && curso != null) {
// Llamar al servicio para agregar el curso al carrito del estudiante
			carritoServicio.agregarCurso(estudiante, curso);
		}
// Redirigir a una página de confirmación o de lista de cursos
		return "redirect:/index"; // Ajusta la redirección según tu aplicación
	}
	
	//Mostrar Cursos en carrito
	 @GetMapping("/cursos/{id}")
	    public String mostrarCursos(@PathVariable("id") Long estudianteId, Model model) {
	        // Lógica para mostrar la lista de cursos (opcional)
	        Estudiante estudiante = estudianteRepositorio.findById(estudianteId).orElse(null);
	        if (estudiante != null) {
	            model.addAttribute("estudiante", estudiante);
	            model.addAttribute("cursos", cursoRepositorio.findAll());
	        }
	        return "carrito"; // Ajusta el nombre de la vista según tu aplicación
	    }

	 @PostMapping("/eliminarCurso")
	    public String eliminarCurso(@RequestParam("estudianteId") Long estudianteId, 
	                                @RequestParam("cursoId") Long cursoId, 
	                                Model model) {
	        Estudiante estudiante = estudianteRepositorio.findById(estudianteId).orElse(null);
	        Curso curso = cursoRepositorio.findById(cursoId).orElse(null);

	        if (estudiante != null && curso != null) {
	            carritoServicio.eliminarCurso(estudiante, curso);
	        }

	        return "redirect:/carrito/" + estudianteId; // Ajusta la redirección según tu aplicación
	    }
	
	 */




