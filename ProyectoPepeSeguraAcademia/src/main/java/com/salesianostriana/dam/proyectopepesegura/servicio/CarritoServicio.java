package com.salesianostriana.dam.proyectopepesegura.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectopepesegura.modelo.Venta;
import com.salesianostriana.dam.proyectopepesegura.modelo.Curso;
import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;
import com.salesianostriana.dam.proyectopepesegura.modelo.LineaVenta;
import com.salesianostriana.dam.proyectopepesegura.repositorio.CarritoRepositorio;
import com.salesianostriana.dam.proyectopepesegura.repositorio.CursoRepositorio;

@Service
public class CarritoServicio {
	@Autowired
    private CarritoRepositorio carritoRepositorio;

    @Autowired
    private CursoRepositorio cursoRepositorio;

    public Venta obtenerCarrito(Estudiante estudiante) {
        return carritoRepositorio.findByEstudiante(estudiante);
    }
    
    public void agregarCurso(Estudiante e, Long idC) {
    	Venta carrito = obtenerCarrito(e);
    	if(carrito == null){//si el carrito no existe , creamos uno nuevo y depués le seteamos el estudiante 
    		carrito = new Venta();
    		carrito.setEstudiante(e);
    	}
    	Curso c =cursoRepositorio.findById(idC).orElse(null);

    	LineaVenta lv = new LineaVenta();
    	lv.setCurso(c);
    	lv.setCarrito(carrito);
    	
    	carrito.getLv().add(lv);
    	carritoRepositorio.save(carrito);
    	
    }
/*
    public void agregarCurso(Estudiante estudiante, Long cursoId) {
        Venta carrito = carritoRepositorio.findByEstudiante(estudiante);
        if (carrito == null) {
            carrito = new Venta();
            carrito.setEstudiante(estudiante);
        }

        Curso curso = cursoRepositorio.findById(cursoId).orElseThrow(() -> new IllegalArgumentException("Curso no encontrado"));
        LineaVenta lv = new LineaVenta();
        lv.setCurso(curso);
        lv.setCarrito(carrito);

        carrito.getLv().add(lv);  
        carritoRepositorio.save(carrito);
    }
    
    
    /*
    public void eliminarCurso(Estudiante estudiante, Long idCurso) {
        Venta carrito = carritoRepositorio.findByEstudiante(estudiante);
        if (carrito != null) {
            carrito.getLv().removeIf(lv -> lv.getCurso().getIdCurso() == idCurso);
            carritoRepositorio.save(carrito);
        }
    }*/
}

