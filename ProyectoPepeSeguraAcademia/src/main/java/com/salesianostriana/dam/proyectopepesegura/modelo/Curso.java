package com.salesianostriana.dam.proyectopepesegura.modelo;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="CURSO")
public class Curso {
		
	@Id
	@GeneratedValue
	private long idCurso;
	
	private String nombre;
	private String nivelDificultad;
	//Lob
	private String duracion;
	private double precio;

public String getNivelDificultad() {
    return nivelDificultad;
}

public void setNivelDificultad(String nivelDificultad) {
    this.nivelDificultad = nivelDificultad;
}
	
	
	@OneToOne(mappedBy = "curso")
	private Certificado certificado;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "curso"  ,cascade = CascadeType.ALL, orphanRemoval = true)
	@Builder.Default
	private List<Material> materiales = new ArrayList<>();

	
	
    
}
