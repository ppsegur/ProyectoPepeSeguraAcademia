package com.salesianostriana.dam.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Data@NoArgsConstructor@AllArgsConstructor
@Builder
public class Certificado {

	@Id
	@GeneratedValue
	private long id;
	private LocalDate fechaExamen;
	private int calificación;
	
	@OneToOne
	@JoinColumn(name = "id_curso")//BDD
	private Curso curso;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_estudiante_certificado"))
	private Estudiante estudiante;
	
}
