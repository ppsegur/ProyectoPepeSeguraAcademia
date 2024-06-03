package com.salesianostriana.dam.proyectopepesegura.modelo;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
	
	private String idioma;
	private String nivelDificultad;
	//Lob
	private String duracion;
	private double precio;

	@OneToOne(mappedBy = "curso")
	private Certificado certificado;
	
	@OneToMany(mappedBy = "curso", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@Builder.Default
	private List<Material> materiales = new ArrayList<>();
}
