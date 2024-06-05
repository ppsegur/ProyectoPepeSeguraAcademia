package com.salesianostriana.dam.proyectopepesegura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;


@Controller
public class MainController {
	
	@GetMapping("/logout")
    public String logOut() {
        return "login";
    }
	@GetMapping({"/","/index"})
	public String mostrarIndice() {
		return "index";
	}
	@GetMapping("/admin/Index")
	public String mostrarIndiceAdmin() {
		return  "admin/indexAdmin";
	}

	@GetMapping("/register")
	public String register(Model model) {
	return "register";
	}
	
}
