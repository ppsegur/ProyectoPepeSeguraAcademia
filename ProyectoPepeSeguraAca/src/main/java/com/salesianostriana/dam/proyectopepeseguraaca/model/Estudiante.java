package com.salesianostriana.dam.proyectopepeseguraaca.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Entity@Data@NoArgsConstructor@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@PrimaryKeyJoinColumn(name = "id")
@SuperBuilder
public class Estudiante extends Usuario{
	
	private String telefono;

	public Estudiante(String username,String contrasena, String nombre, String apellidos, String correo, String dni, String telefono) {
		super(username,contrasena, nombre, apellidos, correo, dni);
		this.telefono = telefono;
	}
	

	/*@OneToMany(mappedBy = "estudiante")
	private List<Certificado> Certificado;*/

	
	/*@OneToMany(mappedBy = "estudiante")
	private List<Pedido> pedidos;*/
	
	
}
