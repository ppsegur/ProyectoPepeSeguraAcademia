package com.salesianostriana.dam.proyectopepesegura.modelo;

import java.time.LocalDate;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;

@Entity
@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ESTUDIANTE")
public class Estudiante implements UserDetails{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue()
	private Long id;
	private String username;
	private String password;	
	private String nombre;
	private String apellidos;
	private String correo;
	private String dni;
	

	private LocalDate fechaNacimiento;
	private String genero;
	
	@Column(name = "no_estudiante")
	private boolean noEstudiante;
	
	
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
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "estudiante",  cascade = CascadeType.ALL, orphanRemoval = true)
	@Builder.Default
	private List<Certificado> Certificado= new ArrayList<>();

	
	@OneToOne
	@JoinColumn(name = "id")
	private Carrito carrito;
}
