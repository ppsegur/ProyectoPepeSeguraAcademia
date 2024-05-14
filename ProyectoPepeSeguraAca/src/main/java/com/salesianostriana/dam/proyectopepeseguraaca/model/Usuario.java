package com.salesianostriana.dam.proyectopepeseguraaca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;


@Entity@Data@NoArgsConstructor@AllArgsConstructor
@SuperBuilder 
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	//lob
	private String username;
	private String contrasena;
	private String nombre;
	private String apellidos;
	private String correo;
	private String dni;
	
	public Usuario(String username, String contrasena, String nombre, String apellidos, String correo, String dni) {
		super();
		this.username= username;
		this.contrasena = contrasena;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.dni = dni;
	}
	
}
