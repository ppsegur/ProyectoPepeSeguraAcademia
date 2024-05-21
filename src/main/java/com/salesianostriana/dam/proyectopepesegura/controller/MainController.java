package com.salesianostriana.dam.proyectopepesegura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;


@Controller
public class MainController {
	
	@GetMapping("/logout")
    public String logOut() {
        return "index";
    }
	@GetMapping("/index")
	public String mostrarIndice() {
		return "index";
	}
	@GetMapping("/adminIndex")
	public String mostrarIndiceAdmin() {
		return  "admin/indexAdmin";
	}
	@GetMapping("/login")
	public String mostrarLogin(Model model) {
		return "login";
	}

	
}
