package com.salesianostriana.dam.proyectopepesegura.controller;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.proyectopepesegura.modelo.Curso;
import com.salesianostriana.dam.proyectopepesegura.modelo.Material;
import com.salesianostriana.dam.proyectopepesegura.servicio.CursoServicio;
import com.salesianostriana.dam.proyectopepesegura.servicio.MaterialServicio;



@Controller
@RequestMapping("/admin")
public class MaterialController {

	@Autowired
	public MaterialServicio materialServicio;
	@Autowired
	CursoServicio cursoServicio;
	
	//Tablas
	@GetMapping("/Material")
	public String listarMateriales(Model model) {
		model.addAttribute("listaMateriales", materialServicio.findAll());
		model.addAttribute("curso",cursoServicio.findAll());
		return "admin/listaMaterial";
	}
	//Mostrar el formulario de añadir material
	@GetMapping("/formularioMaterial")
	public String mostrarFormularioMaterial(Model model) {
		model.addAttribute("listaCurso",cursoServicio.findAll());
		model.addAttribute("material", new Material());
		return "admin/formularioMaterial";
	}
	//
	@PostMapping("/nuevoMaterial/submit")
	public String procesarFormularioMaterial(@ModelAttribute("material") Material m, Model model) {
        Curso curso = m.getCurso();
        if (curso != null && curso.getMateriales()!=null) {
            model.addAttribute("material", m);
            model.addAttribute("listaCurso", cursoServicio.findAll());
            model.addAttribute("error", "El curso seleccionado ya tiene asociado un material.");
            return "admin/formularioMaterial";
        } else {
            materialServicio.save(m);
            return "redirect:/admin/Material";
        }
	}

	//Borrar
	@GetMapping("/borrarMaterial/{idMaterial}")
	public String borrarMaterial(@PathVariable("idMaterial") long idMaterial) {
	    Optional<Material> material = materialServicio.findById(idMaterial);
	    if(material.isPresent()) {
	    materialServicio.delete(material.get());
	        
	    }
	    return "redirect:/admin/Material";
	}

	//Editar
	@GetMapping("/editarMaterial/{idMaterial}")
	public String mostrarFormularioEdicionMaterial(@PathVariable("idMaterial") long idMaterial , Model model) {
		Optional<Material> materialEditar = materialServicio.findById(idMaterial);
		if(materialEditar.isPresent()) {
			model.addAttribute("listaCurso",cursoServicio.findAll());
			model.addAttribute("material",materialEditar.get());
		
			return "admin/editarFormularioMaterial";	
		}else {
			//
			return "redirect:/admin/Material";
		}
	}

	@PostMapping("/editarMaterial/submit")
	public String editarMaterialSubmit(@ModelAttribute("material") Material m,Model model) {
		Curso c = m.getCurso();
		if(c != null && c.getMateriales()!=null) {
			model.addAttribute("material", m);
            model.addAttribute("listaCurso", cursoServicio.findAll());
			model.addAttribute("error", "El curso seleccionado ya tiene asociado un material.");
			return "admin/editarFormularioMaterial";
		}if(c.getMateriales()==m){
			materialServicio.edit(m);
			return "redirect:/admin/Material";
				
		}else {
			materialServicio.edit(m);
			return "redirect:/admin/Material";
		}
	}
	

}
