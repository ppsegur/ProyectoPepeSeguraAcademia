package com.salesianostriana.dam.proyectopepesegura.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectopepesegura.modelo.Venta;
import com.salesianostriana.dam.proyectopepesegura.repositorio.VentaRepositorio;
import com.salesianostriana.dam.proyectopepesegura.servicio.CarritoServicio;
import com.salesianostriana.dam.proyectopepesegura.servicio.VentaServicio;

@Controller
@RequestMapping("/admin")
public class AdminControlador {
	@Autowired
	private VentaRepositorio ventaServicio;
	@GetMapping()
	public String index() {
		return "index";
	}

	 @GetMapping("/admin/ventas")
	    public String listarVentas(Model model) {
	        model.addAttribute("ventas", ventaServicio.findAll() );
	        return "listaVentasAdmin";
	    }
}
