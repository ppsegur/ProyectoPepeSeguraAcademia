package com.example.academiapepesegurarodriguez.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Data@NoArgsConstructor@AllArgsConstructor
@Builder
public class Curso {

	@Id
	@GeneratedValue
	private long id;
	
	private String nombre;
	private String nivelDificultad;
	private LocalDate duracion;
	private double precio;
	/*@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name="fk_curso_profesor"))
	private Profesor profesor;*/
	
	/*@OneToOne(mappedBy = "curso")
	private Certificado certificado;*/
	
	/*@OneToMany(mappedBy = "curso", fetch = FetchType.EAGER)
	@Builder.Default
	private List<Material> materiales = new ArrayList<>();*/
	
}
