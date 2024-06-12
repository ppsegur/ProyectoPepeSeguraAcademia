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
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
	//Asociaciones
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "estudiante",  cascade = CascadeType.ALL, orphanRemoval = true)
	@Builder.Default
	private List<Certificado> Certificado= new ArrayList<>();

	
	

	@ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "estudiante", 
    		cascade = CascadeType.ALL, 
    		fetch = FetchType.EAGER,
    		orphanRemoval = true)
	@Builder.Default
	private List<Venta> carrito = new ArrayList<>();
	
	@ManyToMany
	private List<Estudiante> listaEstudiante ;
	
	
	//Métodos helper 
	/**
	 * Método auxiliar para el tratamiento bidireccional de la asociación. Añade un material
	 * a la colección de materiales de un curso, y asigna a dicho material este curso como el suyo.
	 * @param a
	 */
	public void addCertificado(Certificado c) {
		this.Certificado.add(c);
		c.setEstudiante(this);
	}
	
	/**
	 * Método auxiliar para el tratamiento bidireccional de la asociación. Elimina un material
	 * de la colección de materiales de un curso, y desasigna a dicho mateerial el curso, dejándolo como nulo.
	 * @param a
	 */
	public void removeCertificado(Certificado c) {
		this.Certificado.add(c);
		c.setEstudiante(null);
	
}


	
}