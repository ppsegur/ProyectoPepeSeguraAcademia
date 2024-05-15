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
<<<<<<< HEAD
	public MaterialServicio materialServicio;
	
	//Tablas
=======
	MaterialServicio materialServicio;
	
>>>>>>> main
	@GetMapping("/adminMaterial")
	public String listarMateriales(Model model) {
		model.addAttribute("listaMateriales", materialServicio.findAll());
		return "admin/listaMaterial";
	}
	//Mostrar el formulario de añadir material
<<<<<<< HEAD
	@GetMapping("/adminformularioMaterial")
=======
	@GetMapping("/admin/formularioMaterial")
>>>>>>> main
	public String mostrarFormularioMaterial(Model model) {
		model.addAttribute("material", new Material());
		return "admin/formularioMaterial";
	}
<<<<<<< HEAD
	//
=======
>>>>>>> main
	@PostMapping("/nuevoMaterial/submit")
	public String procesarFormularioMaterial(@ModelAttribute("material") Material m) {
		materialServicio.save(m);		
		return "redirect:/adminMaterial";
	}
<<<<<<< HEAD
	//Borrar
	@GetMapping("/borrarMaterial/{idMaterial}")
	public String borrarMaterial(@PathVariable("idMaterial") long idMaterial) {
	    Optional<Material> material = materialServicio.findById(idMaterial);
	    if(material.isPresent()) {
	        materialServicio.delete(material.get());
	    }
	    return "redirect:/adminMaterial";
	}
	//Editar
	@GetMapping("/editarMaterial/{idMaterial}")
	public String mostrarFormularioEdicionMaterial(@PathVariable("idMaterial") long idMaterial , Model model) {
		Optional<Material> materialEditar = materialServicio.findById(idMaterial);
		if(materialEditar.isPresent()) {
			model.addAttribute("material",materialEditar.get());
		
			return "admin/editarFormularioMaterial";	
		}else {
			//
			return "redirect:/adminMaterial";
		}
	}
	
	@PostMapping("/editarMaterial/submit")
	public String editarMaterialSubmit(@ModelAttribute("material") Material material) {
	    materialServicio.save(material);
		return "redirect:/adminMaterial";
	}


   
}
	
	

=======
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
>>>>>>> main
