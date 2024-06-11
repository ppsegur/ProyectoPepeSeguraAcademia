package com.salesianostriana.dam.proyectopepesegura.controller;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.salesianostriana.dam.proyectopepesegura.repositorio.VentaRepositorio;


@Controller
@RequestMapping("/admin")
public class AdminControlador {
	@Autowired
	private VentaRepositorio ventaServicio;
	@GetMapping()
	public String index() {
		return "index";
	}

	 @GetMapping("/ventas")
	    public String listarVentas(Model model) {
	        model.addAttribute("listaVentas", ventaServicio.findAll() );
	        return "listaVentas";
	    }
}
