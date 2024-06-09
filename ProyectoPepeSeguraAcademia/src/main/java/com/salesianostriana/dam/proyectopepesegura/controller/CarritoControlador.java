package com.salesianostriana.dam.proyectopepesegura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.proyectopepesegura.modelo.Venta;
import com.salesianostriana.dam.proyectopepesegura.modelo.Curso;
import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;
import com.salesianostriana.dam.proyectopepesegura.servicio.CarritoServicio;


@Controller
@RequestMapping("/carrito")
public class CarritoControlador {

    @Autowired
    private CarritoServicio carritoServicio;

    @PostMapping("/agregar")
    public String agregarCurso(@RequestParam Curso curso, @AuthenticationPrincipal Estudiante estudiante) {
        if(curso !=null && estudiante !=null) {
        	carritoServicio.agregarCurso(estudiante, curso);
        	return "redirect:/carrito";
        }
        return "redirect:/index";
    
        
    }

    @GetMapping
    public String verCarrito(@AuthenticationPrincipal Estudiante estudiante, Model model) {
        Venta carrito = carritoServicio.obtenerCarrito(estudiante);
        model.addAttribute("carrito", carrito);
        return "carrito";
    }
/* --> Comentamos para un futuro utilizarlo
    @PostMapping("/eliminar")
    public String eliminarCurso(@RequestParam Long cursoId, @AuthenticationPrincipal Estudiante estudiante) {
        carritoServicio.eliminarCurso(estudiante, cursoId);
        return "redirect:/carrito";
    }*/
}