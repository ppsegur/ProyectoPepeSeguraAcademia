package com.salesianostriana.dam.proyectopepesegura.modelo;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@Table(name = "ESTUDIANTE")
public class Estudiante implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	private String username;
	private String password;	
	private String nombre;
	private String apellidos;
	private String correo;
	private String dni;
	private int edad;
	@Column(name = "no_estudiante")
	private boolean noEstudiante;
	
	public Estudiante(Long id, String username, String password, String nombre, String apellidos, String correo,
			String dni, int edad,boolean noEstudiante) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.correo = correo;
		this.dni = dni;
		this.edad=edad;
		this.noEstudiante = false;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		String role = "ROLE_";
		role += (noEstudiante) ? "ADMIN" : "USER";
		return List.of(new SimpleGrantedAuthority(role));
	}	
	

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	
	/*@OneToMany(mappedBy = "estudiante")
	private List<Certificado> Certificado;

	
	/*@OneToMany(mappedBy = "estudiante")
	private List<Pedido> pedidos;*/
	
}
