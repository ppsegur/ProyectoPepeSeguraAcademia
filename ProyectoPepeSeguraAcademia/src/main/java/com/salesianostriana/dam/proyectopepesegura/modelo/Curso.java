package com.salesianostriana.dam.proyectopepesegura.modelo;

import java.util.ArrayList;

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

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@Table(name="CURSO")
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
	
	
	@OneToOne(mappedBy = "curso")
	private Certificado certificado;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "curso"  ,cascade = CascadeType.ALL, orphanRemoval = true)
	@Builder.Default
	private List<Material> materiales = new ArrayList<>();

	public Curso(long idCurso, String nombre, String nivelDificultad, String duracion, double precio,
			Certificado certificado, List<Material> materiales) {
		super();
		this.idCurso = idCurso;
		this.nombre = nombre;
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
                ", nombre='" + nombre + '\'' +
                  ", nivelDificultad='" + nivelDificultad + '\'' +
                  ", duracion='" + duracion + '\'' +
                   ", duracion='" + duracion + '\'' +
                   
                '}';
    }
}
