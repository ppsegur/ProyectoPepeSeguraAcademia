package com.salesianostriana.dam.proyectopepesegura.servicio;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectopepesegura.modelo.Venta;
import com.salesianostriana.dam.proyectopepesegura.modelo.Curso;
import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;
import com.salesianostriana.dam.proyectopepesegura.modelo.LineaVenta;
import com.salesianostriana.dam.proyectopepesegura.modelo.LineaVentaPk;
import com.salesianostriana.dam.proyectopepesegura.repositorio.CarritoRepositorio;
import com.salesianostriana.dam.proyectopepesegura.repositorio.LineaVentaRepositorio;
import com.salesianostriana.dam.proyectopepesegura.repositorio.VentaRepositorio;

@Service
public class CarritoServicio {
	@Autowired
    private CarritoRepositorio carritoRepositorio;

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
    		carrito.setFinalizada(false);
    		ventaRepositorio.save(carrito);
    	}
    	LineaVentaPk lineaVentaId = new LineaVentaPk();
    	lineaVentaId.setVenta(carrito);
    	lineaVentaId.setId(curso.getIdCurso());
    	boolean cursoYaEnCarrito= lineaVentaRepositorio.existsById(lineaVentaId);
    	if(!cursoYaEnCarrito) {
    		LineaVenta lineaVenta = new LineaVenta();
    		lineaVenta.setCurso(curso);
    		lineaVenta.setVenta(carrito);
    		lineaVentaRepositorio.save(lineaVenta);
    	}
    	/* 1 versiojn
    	LineaVenta lv = new LineaVenta();
    	lv.setCurso(c);
    	lv.setCarrito(carrito);
    	
    	carrito.add(lv);
    	carritoRepositorio.save(carrito);
    	*/
    }
	
   
public void eliminarCurso(Estudiante e, Curso curso) {
    Venta carrito = ventaRepositorio.findByEstudianteAndFinalizada(e, false);
    if (carrito != null) {
        LineaVentaPk lineaVentaId = new LineaVentaPk();
        lineaVentaId.setId(carrito.getIdVenta());
        lineaVentaId.setVenta(carrito);
         
        lineaVentaId.setId(curso.getIdCurso());

        if (lineaVentaRepositorio.existsById(lineaVentaId)) {
            lineaVentaRepositorio.deleteById(lineaVentaId);
        }
    }
} 

}
