package com.salesianostriana.dam.proyectopepesegura.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailParseException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import jakarta.mail.internet.AddressException;
import jakarta.mail.internet.InternetAddress;

@Service
public class MailService {
	
	@Autowired
	    private JavaMailSender javaMailSender;

	    public void sendMail(String from, String to, String subject, String body) {
	    	
	            try {
	                String cleanedFrom = cleanAndValidateEmail(from);
	                String cleanedTo = cleanAndValidateEmail(to);

	                SimpleMailMessage mail = new SimpleMailMessage();
	                mail.setFrom(cleanedFrom);
	                mail.setTo(cleanedTo);
	                mail.setSubject(subject);
	                mail.setText(body);

	                javaMailSender.send(mail);
	            } catch (AddressException e) {
	                throw new MailParseException("Could not parse mail", e);
	            }
	        }

	        private String cleanAndValidateEmail(String email) throws AddressException {
	            if (email == null || email.trim().isEmpty()) {
	                throw new AddressException("Email address is null or empty");
	            }
	            email = email.trim().replaceAll("\\s+", ""); // Remove all whitespace characters
	            InternetAddress emailAddr = new InternetAddress(email);
	            emailAddr.validate();
	            return email;
	        }
	    }
	    
