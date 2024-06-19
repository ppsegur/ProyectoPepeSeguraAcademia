package com.salesianostriana.dam.proyectopepesegura.controller;

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
import com.salesianostriana.dam.proyectopepesegura.servicio.EstudianteServicio;
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
	@Autowired
	private EstudianteServicio estudianteServicio;

	// Controller para mostrarCarrito
	@GetMapping()
	public String mostrarCarrito(@AuthenticationPrincipal Estudiante e, Model model) {
		if (carritoServicio.hayCarritoCreado(e)) {
			Venta carrito = carritoServicio.getCarrito(e);
			model.addAttribute("venta", carrito);
			model.addAttribute("carritoVacio", carrito.getLv().isEmpty());
			model.addAttribute("Importe", carritoServicio.getImporteTotal(e));
		
		} else {
			model.addAttribute("carritoVacio", true);
		}
		return "carrito";
	}

	// Controller para añadirProducto
	@PostMapping("/agregarCurso/{idCurso}")
	public String añadirProducto(@AuthenticationPrincipal Estudiante e, @PathVariable("idCurso") Long idProducto,
			Model model) {
		Optional<Curso> curso = cursoServicio.findById(idProducto);

		if (curso.isPresent()) {
			carritoServicio.addProducto(e, curso.get());
			return "redirect:/carrito";
		}
		return "redirect:/index";
	}

	// Controller para finalizar compra
	@PostMapping("/checkout")
	public String finalizarCompra(@AuthenticationPrincipal Estudiante e) {

		carritoServicio.finalizarCompra(e);
		return "redirect:/index";
	}

	// Controller para eliminar producto
	@PostMapping("/eliminarProducto/{idCurso}")
	public String eliminarProducto(@AuthenticationPrincipal Estudiante e, @PathVariable("idCurso") Long idProducto) {
		Optional<Curso> producto = cursoServicio.findById(idProducto);

		if (producto.isPresent()) {
			carritoServicio.eliminarCurso(e, producto.get());
			return "redirect:/carrito";
		}
		return "redirect:/cursosEstudiantes";
	}


	//suscripcion
	@GetMapping("/suscripcion")
	public String mostrarSuscripcion(@AuthenticationPrincipal Estudiante e, Model model) {
		model.addAttribute("estudiante", e);
		return "suscripcionCarrito";
	}
	@PostMapping("/suscripcion/comprar")
	public String comprarSuscripcion(@AuthenticationPrincipal Estudiante e, Model model) {
		ventaServicio.comprarSuscripcion(e);
		
		return "redirect:/carrito/suscripcionExitosa";
	}
	@GetMapping("/suscripcionExitosa")
	public String suscripcionFinalizada(@AuthenticationPrincipal Estudiante e, Model model) {
		e.setSuscrito(true);
		estudianteServicio.edit(e);
		model.addAttribute("estudiante",e);
		return "SuscripcionExito";
	}
	
	
	
}