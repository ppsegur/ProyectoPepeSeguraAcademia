package com.salesianostriana.dam.proyectopepesegura.controller;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.salesianostriana.dam.proyectopepesegura.excepcion.ExcepcionCeroVentas;

@ControllerAdvice
public class ExcepcionCeroVentasController {
	
	

	    @ExceptionHandler(ExcepcionCeroVentas.class)
	    public String handleExcepcionCeroVentas(Model model, ExcepcionCeroVentas ex) {
	        model.addAttribute("mensajeError", ex.getMessage());
	        return "errorVentas.html"; // Esta debería ser una página de error específica.
	    }
	}


