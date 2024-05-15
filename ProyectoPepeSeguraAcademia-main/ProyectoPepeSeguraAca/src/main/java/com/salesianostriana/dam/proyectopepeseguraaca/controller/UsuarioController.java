package com.salesianostriana.dam.proyectopepeseguraaca.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.salesianostriana.dam.proyectopepeseguraaca.servicios.UsuarioServicio;
import org.springframework.web.bind.annotation.GetMapping;



@Controller 
public class UsuarioController {
	
	@Autowired
	UsuarioServicio usuarioServicio;
	
	@GetMapping({" ","/"})
	public String mostrarIndice() {
		return "Index";
	}
	
}
