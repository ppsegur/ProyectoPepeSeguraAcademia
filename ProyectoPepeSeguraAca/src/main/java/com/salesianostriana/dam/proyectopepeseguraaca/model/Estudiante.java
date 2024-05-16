package com.salesianostriana.dam.proyectopepeseguraaca.model;

import com.salesianostriana.dam.proyectopepeseguraaca.model.Usuario;

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
	

	/*@OneToMany(mappedBy = "estudiante")
	private List<Certificado> Certificado;*/

	
	/*@OneToMany(mappedBy = "estudiante")
	private List<Pedido> pedidos;*/
	
	
}
