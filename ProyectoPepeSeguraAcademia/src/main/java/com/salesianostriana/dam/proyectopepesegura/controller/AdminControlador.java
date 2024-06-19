package com.salesianostriana.dam.proyectopepesegura.controller;




import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectopepesegura.excepcion.ExcepcionCeroVentas;
import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;
import com.salesianostriana.dam.proyectopepesegura.modelo.Venta;
import com.salesianostriana.dam.proyectopepesegura.servicio.VentaServicio;



@Controller
@RequestMapping("/admin")
public class AdminControlador {

	@Autowired
	private VentaServicio ventaServicio;
	
	@GetMapping()
	public String index() {
		return "index";
	}

	   @GetMapping("/ventas")
	    public String mostrarVentas(Model model) {
	        List<Venta> ventas = ventaServicio.findAll();
	        if(!ventas.isEmpty()) {
	        	Estudiante estudianteConMasVentas = ventaServicio.getEstudianteConMasVentas();
		        double totalVentas = ventaServicio.getTotalVentas();
		
		        	model.addAttribute("totalVentas", totalVentas);
		        	   model.addAttribute("estudianteConMasVentas", estudianteConMasVentas);
		
		        model.addAttribute("listaVentas", ventas);
		     
		        

		        return "admin/listaVentas";
	        }else {
	        	throw new ExcepcionCeroVentas();
	        }
	        
	        
	    }
	 //Borrar
		@GetMapping("/borrarVenta/{idVenta}")
		public String borrarVenta(@PathVariable("idVenta") long idVenta) {
		  Optional<Venta> venta = ventaServicio.findById(idVenta);
		    if(venta != null) {
		    	Venta ventaVerdadera = venta.get();
		        
		     
		        ventaServicio.delete(ventaVerdadera);
		        
		        Estudiante estudiante = ventaVerdadera.getEstudiante();
		        estudiante.removeVenta(ventaVerdadera); 
		        
	    }
		    return "/admin/listaVentas";

		}}

