package com.salesianostriana.dam.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.salesianostriana.dam.model.Certificado;
import com.salesianostriana.dam.model.Estudiante;
import com.salesianostriana.dam.services.CertificadoService;

@Controller
@RequestMapping("/admin/certificado")
public class CertificadoController {

	@Autowired
	CertificadoService certificadoServicio;

	public CertificadoController(CertificadoService certificadoServicio) {
		this.certificadoServicio = certificadoServicio;
	}
	@GetMapping({"/", "/listaCertificado"})
	public String listarTodos(Model model) {
		model.addAttribute("listaCertificado",certificadoServicio.findAll() );
		return "listaDeCertificado";//No colocada
	}
	@GetMapping("/nuevo")
	public String mostrarFormulario(Model model) {
		model.addAttribute("certificado", new Certificado());
		return "FormularioCertificado";
	}
	@PostMapping("/nuevo/submit")
	public String procesarFormulario(@ModelAttribute("certificado") Certificado c) {
		certificadoServicio.save(c);
		return "rediret:/";
	}
	@GetMapping("/editar/{id}")
	public String mostrarFormularioEdicion(@PathVariable("id") long id, Model model) {
		
		if(certificadoServicio.findById(id).isPresent()) {
			model.addAttribute("certificado", certificadoServicio.findById(id).get());
			return "FormularioCertificado";
		}else {
			return "redirect:/";
		}
	}
	@PostMapping("/editar/submit")
	public String procesarFormularioEdicion(@ModelAttribute("estudiante") Certificado c) {
		certificadoServicio.edit(c);
		return "redirect:/";
	}
	/**
	 * Método para borrar 
	 * @param id
	 * @return 
	 */
	@GetMapping("/borrar/{id}")
	public String borrar(@PathVariable("id") long id) {
		certificadoServicio.deleteById(id);
		return "redirect:/";
	}
}
