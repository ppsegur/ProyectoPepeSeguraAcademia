package com.salesianostriana.dam.proyectopepesegura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

	@GetMapping("/index")
	public String mostrarIndice() {
		return "index";
	}
	@GetMapping("/adminIndex")
	public String mostrarIndiceAdmin() {
		return  "admin/indexAdmin";
	}
	@GetMapping("/login")
	public String mostrarLogin() {
		return "login";
	}

	
}
