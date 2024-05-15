package com.salesianostriana.dam.proyectopepeseguraaca.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectopepeseguraaca.model.Material;
import com.salesianostriana.dam.proyectopepeseguraaca.servicios.MaterialServicio;


@Controller
public class MaterialController {

	@Autowired
	MaterialServicio materialServicio;
	
	@GetMapping("/adminMaterial")
	public String listarMateriales(Model model) {
		model.addAttribute("listaMateriales", materialServicio.findAll());
		return "admin/listaMaterial";
	}
	//Mostrar el formulario de añadir material
	@GetMapping("/admin/formularioMaterial")
	public String mostrarFormularioMaterial(Model model) {
		model.addAttribute("material", new Material());
		return "admin/formularioMaterial";
	}
	@PostMapping("/nuevoMaterial/submit")
	public String procesarFormularioMaterial(@ModelAttribute("material") Material m) {
		materialServicio.save(m);		
		return "redirect:/adminMaterial";
	}
	/*
	//borrar
	@GetMapping("/borrarMaterial/{id}")
	public String borrarMaterial(@PathVariable("idMaterial") long idMaterial) {
		Optional<Material> material = materialServicio.deleteById(idMaterial);
		if(material.isPresent())
		return "redirect:/adminMaterial";
	}
	
	
	*/
	
}
