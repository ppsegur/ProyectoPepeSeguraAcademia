package com.salesianostriana.dam.proyectopepesegura.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectopepesegura.modelo.Material;
import com.salesianostriana.dam.proyectopepesegura.servicio.MaterialServicio;



@Controller
public class MaterialController {

	@Autowired
	public MaterialServicio materialServicio;
	
	//Tablas
	@GetMapping("/admin/Material")
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
	//
	@PostMapping("/admin/nuevoMaterial/submit")
	public String procesarFormularioMaterial(@ModelAttribute("material") Material m) {
		materialServicio.save(m);		
		return "redirect:/admin/Material";
	}
	//Borrar
	@GetMapping("/admin/borrarMaterial/{idMaterial}")
	public String borrarMaterial(@PathVariable("idMaterial") long idMaterial) {
	    Optional<Material> material = materialServicio.findById(idMaterial);
	    if(material.isPresent()) {
	        materialServicio.delete(material.get());
	    }
	    return "redirect:/admin/Material";
	}
	//Editar
	@GetMapping("/admin/editarMaterial/{idMaterial}")
	public String mostrarFormularioEdicionMaterial(@PathVariable("idMaterial") long idMaterial , Model model) {
		Optional<Material> materialEditar = materialServicio.findById(idMaterial);
		if(materialEditar.isPresent()) {
			model.addAttribute("material",materialEditar.get());
		
			return "admin/editarFormularioMaterial";	
		}else {
			//
			return "redirect:/admin/Material";
		}
	}
	
	@PostMapping("/admin/editarMaterial/submit")
	public String editarMaterialSubmit(@ModelAttribute("material") Material material) {
	    materialServicio.save(material);
		return "redirect:/admin/Material";
	}

}
