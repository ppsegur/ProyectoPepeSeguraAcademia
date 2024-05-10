package com.example.academiapepesegurarodriguez.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity@Data@NoArgsConstructor@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@SuperBuilder 
public class Estudiante extends Usuario {
	
	private String telefono;

	/*public Estudiante(String contraseña, String nombre, String apellidos, String correo, String dni, String telefono) {
		super(contraseña, nombre, apellidos, correo, dni);
		this.telefono = telefono;
	}*/
	

	/*@OneToMany(mappedBy = "estudiante")
	private List<Certificado> Certificado;*/

	
	/*@OneToMany(mappedBy = "estudiante")
	private List<Pedido> pedidos;*/
	
	

}
