package com.salesianostriana.dam.proyectopepeseguraaca.model;

import jakarta.persistence.Entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter@Setter
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@NoArgsConstructor
//@AllArgsConstructor
@SuperBuilder
@Entity
public class Profesor extends Usuario {
	
	/*@OneToMany(mappedBy="curso", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Curso> cursosImpartidos = new ArrayList<>();*/

	//Constructor
	/*public Profesor(String contraseña, String nombre, String apellidos, String correo, String dni, String dni2,
			List<Estudiante> estudiante) {
		super(contraseña, nombre, apellidos, correo, dni);
		this.cursosImpartidos = cursosImpartidos;
	}*/
}
