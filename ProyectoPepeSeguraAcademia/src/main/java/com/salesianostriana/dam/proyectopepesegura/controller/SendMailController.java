package com.salesianostriana.dam.proyectopepesegura.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.salesianostriana.dam.proyectopepesegura.servicio.MailService;

@Controller
public class SendMailController {
	//Investigación mandar email en mmi caso mi idea es que el usuario tenga la oportunidad de mandar sugerencias o quejas al administrador de la aplicación
	   @Autowired
	    private MailService mailService;

	   @GetMapping("/sendMail")
	    public String mostrarFormularioEmail() {
	        return "SendMail";
	    }

	    @PostMapping("/sendMail")
	    public String sendMail(@RequestParam("name") String name, @RequestParam("mail") String mail, @RequestParam("subject") String subject, @RequestParam("body") String body) {

	        String message = body + "\n\n Datos de contacto: " + "\nNombre: " + name + "\nE-mail: " + mail;
	        mailService.sendMail("tuCorreo@dominio.com", mail, subject, message);

	        return "SendMail";
	    }
}
