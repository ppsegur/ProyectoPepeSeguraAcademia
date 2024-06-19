package com.salesianostriana.dam.proyectopepesegura.modelo;

import java.time.LocalDate;



import java.util.Collection;

import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import io.micrometer.common.lang.NonNull;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;

import lombok.AllArgsConstructor;

import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import lombok.NoArgsConstructor;

import lombok.ToString;

import java.util.ArrayList;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "ESTUDIANTE")
public class Estudiante implements UserDetails{
	

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(unique = true)
	private String username;
	
	@NonNull
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
    
	@Builder.Default
	 @OneToMany(mappedBy = "estudiante", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<Venta> carrito = new ArrayList<>();
	
	
	
	 @ManyToMany(fetch = FetchType.EAGER)
	    @JoinTable(
	        name = "Favorito",
	        joinColumns = @JoinColumn(name = "estudiante_id"),
	        inverseJoinColumns = @JoinColumn(name = "curso_id")
	       
	    )
	 	@Builder.Default
	    private List<Curso> cursosFavoritos = new ArrayList<Curso>();
	
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
		this.Certificado.remove(c);
		c.setEstudiante(null);
	
}
	//Metodos helper para añadir los favoritos 
	public void addFavoritos(Curso c) {
		this.cursosFavoritos.add(c);
		c.getEstudiantesFavoritos().add(this);
	}
	
	public void removeFavorito(Curso c) {
		c.getEstudiantesFavoritos().remove(this);
		this.cursosFavoritos.remove(c);
	
	}
	
	
	public void removeVenta(Venta venta) {
        this.carrito.remove(venta);
        venta.setEstudiante(null);
    }
	
}