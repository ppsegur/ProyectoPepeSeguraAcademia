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
		if (!ventaServicio.hayProductosEnCarrito(estudiante, curso)) {
			carrito.addLineaVenta(LineaVenta.builder()
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
		return ventaServicio.getVentasSinFinalizar(e).orElseGet(() -> crearCarrito(e));
	}

	// Productos en carrito
	public Map<Curso, Integer> getProductosEnCarrito(Estudiante e) {
	    Venta carrito = getCarrito(e);
	    if (carrito != null) {
	        return carrito.getLv().stream()
	            .collect(Collectors.toMap(LineaVenta::getCurso, lv -> 1));
	    } else {
	        return Collections.emptyMap(); // O devuelve un mapa vacío o maneja de otra manera los casos nulos
	    }
	}

	// Importe Total
	public double getImporteTotal(Estudiante e) {
		return getCarrito(e).getLv().stream().mapToDouble(LineaVenta::getPrecioLineaVenta).sum();
	}
		/*
		 * public void agregarCurso(Estudiante e, Curso curso) {
		 * 
		 * Venta carrito =ventaRepositorio.findByEstudianteAndFinalizada(e, false);
		 * 
		 * if(carrito == null){//si el carrito no existe , creamos uno nuevo y depués le
		 * seteamos el estudiante carrito = new Venta(); carrito.setEstudiante(e);
		 * carrito.setFinalizada(false); ventaRepositorio.save(carrito); } LineaVentaPk
		 * lineaVentaId = new LineaVentaPk(); lineaVentaId.setVenta(carrito);
		 * lineaVentaId.setId(curso.getIdCurso()); boolean cursoYaEnCarrito=
		 * lineaVentaRepositorio.existsById(lineaVentaId); if(!cursoYaEnCarrito) {
		 * LineaVenta lineaVenta = new LineaVenta(); lineaVenta.setCurso(curso);
		 * lineaVenta.setVenta(carrito); lineaVentaRepositorio.save(lineaVenta); } /* 1
		 * versiojn LineaVenta lv = new LineaVenta(); lv.setCurso(c);
		 * lv.setCarrito(carrito);
		 * 
		 * carrito.add(lv); carritoRepositorio.save(carrito); // }
		 * 
		 * 
		 * public void eliminarCurso(Estudiante e, Curso curso) { Venta carrito =
		 * ventaRepositorio.findByEstudianteAndFinalizada(e, false); if (carrito !=
		 * null) { LineaVentaPk lineaVentaId = new LineaVentaPk();
		 * lineaVentaId.setId(carrito.getIdVenta()); lineaVentaId.setVenta(carrito);
		 * 
		 * lineaVentaId.setId(curso.getIdCurso());
		 * 
		 * if (lineaVentaRepositorio.existsById(lineaVentaId)) {
		 * lineaVentaRepositorio.deleteById(lineaVentaId); } }
		 */

	
}
