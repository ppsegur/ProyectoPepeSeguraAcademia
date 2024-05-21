package com.salesianostriana.dam.proyectopepesegura.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Curso {
		
	@Id
	@GeneratedValue()
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
	
	
	/*@OneToOne(mappedBy = "curso")
	private Certificado certificado;*/
	
	/*@OneToMany(mappedBy = "curso", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Material> materiales = new ArrayList<>();*/
}
