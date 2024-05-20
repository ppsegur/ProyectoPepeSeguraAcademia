package com.salesianostriana.dam.proyectopepesegura.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@GetMapping({" ","/"})
	public String mostrarIndice() {
		return "Index";
	}
	@GetMapping("/indexAmdmin")
	public String mostrarIndiceAdmin() {
		return  "admin/indexAdmin";
	}
}
