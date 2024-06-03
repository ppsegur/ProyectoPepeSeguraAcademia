package com.salesianostriana.dam.proyectopepesegura.modelo;

import java.util.ArrayList;

import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


import jakarta.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Entity
@Data
@NoArgsConstructor
@Builder
@Table(name="CURSO")
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

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "curso"  ,cascade = CascadeType.ALL, orphanRemoval = true)
	@Builder.Default
	private List<Material> materiales = new ArrayList<>();

	public Curso(long idCurso, String idioma, String nivelDificultad, String duracion, double precio,
			Certificado certificado, List<Material> materiales) {
		super();
		this.idCurso = idCurso;
		this.idioma = idioma;
		this.nivelDificultad = nivelDificultad;
		this.duracion = duracion;
		this.precio = precio;
		this.certificado = certificado;
		this.materiales = materiales;
	}
	@Override
    public String toString() {
        return "Curso{" +
                "id=" + idCurso +
                ", idioma='" + idioma + '\'' +
                  ", nivelDificultad='" + nivelDificultad + '\'' +
                  ", duracion='" + duracion + '\'' +
                   ", duracion='" + duracion + '\'' +
                   
                '}';
    }

}
