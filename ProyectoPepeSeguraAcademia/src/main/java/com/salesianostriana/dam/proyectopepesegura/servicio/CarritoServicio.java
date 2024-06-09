package com.salesianostriana.dam.proyectopepesegura.servicio;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectopepesegura.modelo.Venta;
import com.salesianostriana.dam.proyectopepesegura.modelo.Curso;
import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;
import com.salesianostriana.dam.proyectopepesegura.modelo.LineaVenta;
import com.salesianostriana.dam.proyectopepesegura.modelo.LineaVentaPk;
import com.salesianostriana.dam.proyectopepesegura.repositorio.CarritoRepositorio;
import com.salesianostriana.dam.proyectopepesegura.repositorio.CursoRepositorio;
import com.salesianostriana.dam.proyectopepesegura.repositorio.LineaVentaRepositorio;
import com.salesianostriana.dam.proyectopepesegura.repositorio.VentaRepositorio;

@Service
public class CarritoServicio {
	@Autowired
    private CarritoRepositorio carritoRepositorio;

    @Autowired
    private CursoRepositorio cursoRepositorio;
    
    @Autowired
    private VentaRepositorio ventaRepositorio;
    
    @Autowired
    private LineaVentaRepositorio lineaVentaRepositorio;

    public Venta obtenerCarrito(Estudiante estudiante) {
        return carritoRepositorio.findByEstudiante(estudiante);
    }
    
    public void agregarCurso(Estudiante e, Curso curso) {
    	Venta carrito =ventaRepositorio.findByEstudianteAndFinalizada(e, false); 
    	if(carrito == null){//si el carrito no existe , creamos uno nuevo y depués le seteamos el estudiante 
    		carrito = new Venta();
    		carrito.setEstudiante(e);
    		carrito.setFinalizado(false);
    		ventaRepositorio.save(carrito);
    	}
    	LineaVentaPk lineaVentaId = new LineaVentaPk(carrito.getIdVenta(), carrito.g);
    	boolean cursoYaEnCarrito= lineaVentaRepositorio.existsById(lineaVentaId);
    	if(!cursoYaEnCarrito) {
    		LineaVenta lineaVenta = new LineaVenta(lineaVentaId, carrito.getIdVenta(), curso.getIdCurso());
            lineaVentaRepositorio.save(lineaVenta);
    	}
    	/*
    	LineaVenta lv = new LineaVenta();
    	lv.setCurso(c);
    	lv.setCarrito(carrito);
    	
    	carrito.getLv().add(lv);
    	carritoRepositorio.save(carrito);
    	*/
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

