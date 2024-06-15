package com.salesianostriana.dam.proyectopepesegura.servicio;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectopepesegura.modelo.Venta;
import com.salesianostriana.dam.proyectopepesegura.modelo.Curso;
import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;
import com.salesianostriana.dam.proyectopepesegura.modelo.LineaVenta;

import com.salesianostriana.dam.proyectopepesegura.repositorio.CarritoRepositorio;


@Service
public class CarritoServicio {
	
	@Autowired
	private CarritoRepositorio carritoRepositorio;

	@Autowired
	private VentaServicio ventaServicio;
	
	@Autowired
	private CursoServicio cursoServicio;

	public Venta obtenerCarrito(Estudiante estudiante) {
		return carritoRepositorio.findByEstudiante(estudiante);
	}

	// Metodo agregar producto
	public void addProducto(Estudiante estudiante, Curso curso) {
		Venta carrito = getCarrito(estudiante);
		//Traemos la venta 
		if (!ventaServicio.hayProductosEnCarrito(estudiante, curso)) {
			carrito.addLineaVenta(LineaVenta.builder() //añadimos la linea Venta al carrito
					.curso(curso).
					build());
		} else {
			Optional<LineaVenta> lv = BuscarPorCurso(estudiante, curso);
			if (lv.isPresent()) {

			}
		}
		ventaServicio.edit(carrito);
	}

	// Método para eliminar un curso
	public void eliminarCurso(Estudiante e, Curso c) {
		Venta carrito = getCarrito(e);
		Optional<LineaVenta> eliminar = BuscarPorCurso(e, c);
		if (eliminar.isPresent()) {
			carrito.removeLineaVenta(eliminar.get());
			ventaServicio.edit(carrito);
		}
	}

	// BuscarporCurso
	private Optional<LineaVenta> BuscarPorCurso(Estudiante e, Curso c) {
		Venta carrito = getCarrito(e);
		return carrito.getLv().stream().filter(lv -> lv.getCurso().getIdCurso() == c.getIdCurso()).findFirst();
		//en la labda lo que hacemos es coger el id del producto que nos pasan y lo comparamos, y nos devolverá el perimero que encuentre
	}

	// Finalizar comprar
	public void finalizarCompra(Estudiante e) {
		Venta carrito = getCarrito(e);
		carrito.getLv().forEach(lineaVenta ->{ //esta lambda recorre los cursos en el carrito y setea su atributo bolleano comprado para que no nos aparezca despues de comprarlo
			Curso c = lineaVenta.getCurso();
			c.setComprado(true);
			cursoServicio.save(c);
			});
		carrito.setFinalizada(true);
		carrito.setFechaPedido(LocalDate.now());
		carrito.setImporteTotal(getImporteTotal(e));

		ventaServicio.edit(carrito);
	}

	// Hay carrito creado
	public boolean hayCarritoCreado(Estudiante e) {
		return ventaServicio.existeVentaSinFinalizar(e);
	}

	// Crea carrito
	public Venta crearCarrito(Estudiante e) {

		Venta carrito = Venta.builder().estudiante(e).finalizada(false).build();
		return carrito;

	}

	// Método obtener el carrito de un estudiante
	public Venta getCarrito(Estudiante e) {
		return ventaServicio.getVentasSinFinalizar(e).orElseGet(() -> crearCarrito(e));//nos devuelve la venta sin finalizar y si no me crea un carrito
	}

	// Productos en carrito
	public Map<Curso, Integer> getProductosEnCarrito(Estudiante e) {
	    Venta carrito = getCarrito(e);
	    if (carrito != null) {
	        return carrito.getLv().stream()
	            .collect(Collectors.toMap(LineaVenta::getCurso,lv -> 1));
	    } else {
	        return Collections.emptyMap(); // O devuelve un mapa vacío o maneja de otra manera los casos nulos
	    }
	}

	// Importe Total calcula
	public double getImporteTotal(Estudiante e) {
		//lo que hacemos es cojer de los stream de linea venta su precio y despues sumamos todo
		return getCarrito(e).getLv().stream().mapToDouble(LineaVenta::getPrecioLineaVenta).sum();
	}
	
}
