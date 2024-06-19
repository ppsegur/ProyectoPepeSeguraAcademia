package com.salesianostriana.dam.proyectopepesegura.servicio;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectopepesegura.base.BaseServiceImpl;
import com.salesianostriana.dam.proyectopepesegura.modelo.Curso;
import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;
import com.salesianostriana.dam.proyectopepesegura.modelo.Venta;
import com.salesianostriana.dam.proyectopepesegura.repositorio.VentaRepositorio;

@Service
public class VentaServicio extends BaseServiceImpl<Venta, Long, VentaRepositorio>{
	@Autowired
    private VentaRepositorio ventaRepositorio;
	
	public Optional<Venta> obtenerVentasPorEstudiante(Estudiante estudiante) {
	        return ventaRepositorio.findById(estudiante.getId());
	    }
	
	 public List<Venta> obtenerVentaParaEstudiante(Estudiante e){
		 return e.getCarrito();
	 }
    // Método para verificar si existe una venta sin finalizar
    public boolean existeVentaSinFinalizar(Estudiante estudiante) {
        return ventaRepositorio.existsByEstudianteAndFinalizadaFalse(estudiante);
    }

    // Método para obtener ventas sin finalizar de un estudiante
    public Optional<Venta> getVentasSinFinalizar(Estudiante estudiante) {
        return ventaRepositorio.findByEstudianteAndFinalizadaFalse(estudiante);
    }

    // Método para editar una venta
    public Venta edit(Venta venta) {
      return  ventaRepositorio.save(venta);
    }

   

    // Método para verificar si hay productos en el carrito
    public boolean hayProductosEnCarrito(Estudiante estudiante, Curso curso) {
        Optional<Venta> venta = getVentasSinFinalizar(estudiante);
        if (venta.isPresent()) {
            return venta.get().getLv().stream()
                .anyMatch(lv -> lv.getCurso().equals(curso));
        }
        return false;
    }

    // Método para guardar una venta
    public Venta save(Venta venta) {
        return ventaRepositorio.save(venta);
    }
    
    public List<Venta> obtenerTodasLasVentas(Estudiante e) {
        return ventaRepositorio.findByEstudiante(e);
    }
    
    //Método para obtener el estudainte con más ventas
    public Estudiante getEstudianteConMasVentas() {
        return ventaRepositorio.findEstudianteConMasVentas();
    }

    
    //Método para obtener el total de ventas 
    public double getTotalVentas() {
        Double totalVentas = ventaRepositorio.findTotalVentas();
        return totalVentas != null ? totalVentas : 0.00;
    }
}

