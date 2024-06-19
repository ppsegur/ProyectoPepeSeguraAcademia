package com.salesianostriana.dam.proyectopepesegura.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;




@Controller
public class MainController {
	
	@GetMapping("/logout")
    public String logOut() {
        return "login";
    }
	@GetMapping({"/","/index"})
	public String mostrarIndice(@AuthenticationPrincipal Estudiante e,Model model) {
		model.addAttribute("estudiante", e);
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
