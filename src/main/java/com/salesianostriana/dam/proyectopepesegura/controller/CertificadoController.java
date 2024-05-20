package com.salesianostriana.dam.proyectopepesegura.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.salesianostriana.dam.proyectopepesegura.modelo.Certificado;
import com.salesianostriana.dam.proyectopepesegura.servicio.CertificadoServicio;

@Controller
public class CertificadoController {
	@Autowired
	CertificadoServicio certificadoServicio;


	@GetMapping("/adminCertificado")
	public String listarCertificados(Model model) {
		model.addAttribute("listaCertificado",certificadoServicio.findAll() );
		return "admin/listaCertificado";
	}
	//mostrar formulario para añadir un nuevo certificado
	@GetMapping("/adminformularioCertificado")
	public String mostrarFormularioCertificado(Model model) {
		model.addAttribute("certificado", new Certificado());
		return "admin/formularioCertificado";
	}
	@PostMapping("/nuevoCertificado/submit")
	public String procesarFormularioCertificado(@ModelAttribute("certificado") Certificado c) {
		certificadoServicio.save(c);
		return "redirect:/adminCertificado";
	}
	@GetMapping("/editarCertificado/{idCertificado}")
	public String mostrarFormularioEdicion(@PathVariable("idCertificado") long id, Model model) {
		Optional<Certificado> certificadoEditar = certificadoServicio.findById(id);
		if(certificadoEditar.isPresent()) {
			model.addAttribute("certificado", certificadoEditar.get());
			return "admin/editarFormularioCertificado";
		}else {
			return "redirect:/adminCertificado";
		}
	}
	@PostMapping("/editarCertificado/submit")
	public String procesarFormularioEdicionCertificado(@ModelAttribute("certificado") Certificado c) {
		certificadoServicio.edit(c);
		return "redirect:/adminCertificado";
	}
	/**
	 * Método para borrar 
	 * @param id
	 * @return 
	 */
	@GetMapping("/borrarCertificado/{idCertificado}")
	public String borrar(@PathVariable("idCertificado") long id) {
	Optional<Certificado> certificado = certificadoServicio.findById(id);
		if(certificado.isPresent()){
		certificadoServicio.delete(certificado.get());
		}
		return "redirect:/adminCertificado";
		
	}
}
