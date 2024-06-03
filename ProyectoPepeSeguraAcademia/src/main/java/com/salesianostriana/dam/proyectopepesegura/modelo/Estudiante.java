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
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;

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
	@GeneratedValue()
	private Long id;
	private String username;
	private String password;	
	private String nombre;
	private String apellidos;
	private String correo;
	private String dni;
	
	@Column(name="fecha_nacimiento")
	private LocalDate fechaNacimiento;
	private String genero;
	
	@Column(name = "no_estudiante")
	private boolean noEstudiante;
	
	 public Estudiante(Long id, String username, String password, String nombre, String apellidos, String correo,
	            String dni, LocalDate fechaNacimiento, String genero, boolean noEstudiante, List<Certificado> certificados) {
	        this.id = id;
	        this.username = username;
	        this.password = password;
	        this.nombre = nombre;
	        this.apellidos = apellidos;
	        this.correo = correo;
	        this.dni = dni;
	        this.fechaNacimiento = fechaNacimiento;
	        this.genero = genero;
	        this.noEstudiante = noEstudiante;
	        this.Certificado = certificados;
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
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "estudiante",  cascade = CascadeType.ALL, orphanRemoval = true)
	@Builder.Default
	private List<Certificado> Certificado= new ArrayList<>();

	
	
}
