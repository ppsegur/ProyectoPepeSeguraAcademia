package com.salesianostriana.dam.proyectopepesegura.controller;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;
import com.salesianostriana.dam.proyectopepesegura.modelo.Venta;
import com.salesianostriana.dam.proyectopepesegura.repositorio.VentaRepositorio;
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
	        Estudiante estudianteConMasVentas = ventaServicio.getEstudianteConMasVentas();
	        double totalVentas = ventaServicio.getTotalVentas();
	
	        	model.addAttribute("totalVentas", totalVentas);
	        	   model.addAttribute("estudianteConMasVentas", estudianteConMasVentas);
	
	        model.addAttribute("listaVentas", ventas);
	     
	        

	        return "admin/listaVentas";
	    }
}
