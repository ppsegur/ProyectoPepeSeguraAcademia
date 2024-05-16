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
	
	
	
	
	public Profesor(String username, String contrasena, 
			String nombre, String apellidos, String correo, String dni) {
		super(username, contrasena, nombre, apellidos, correo, dni);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return false;
	}
	
	/*@OneToMany(mappedBy="curso", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Curso> cursosImpartidos = new ArrayList<>();*/

	
}
