package com.salesianostriana.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import com.salesianostriana.dam.services.CursoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller
@RequestMapping("/admin/curso")
public class CursoController {
	@Autowired
<<<<<<< HEAD
	private CursoService cursoService;
=======
	 CursoService cursoService;
>>>>>>> bea6ad7cdd1dcd1ecc1ff2f343d38f3b827969f5
	
	public CursoController(CursoService cursoService) {
		this.cursoService = cursoService;
	}
	
	@GetMapping("/")
	public String getMethodName(Model model) {
		model.addAttribute("listaCurso", cursoService.findAll() );
		return "list-Curso";
	}
	
}
