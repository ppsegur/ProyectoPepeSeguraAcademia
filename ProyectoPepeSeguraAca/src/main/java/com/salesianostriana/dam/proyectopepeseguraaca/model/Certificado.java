package com.salesianostriana.dam.proyectopepeseguraaca.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data@NoArgsConstructor@AllArgsConstructor
@Builder
public class Certificado {

	@Id
	@GeneratedValue
	private long idCertificado;
	private LocalDate fechaExamen;
	private int calificacion;
	
	/*@OneToOne
	@JoinColumn(name = "id_curso")//BDD
	private Curso curso;*/

	/*@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_estudiante_certificado"))
	private Estudiante estudiante;*/
	
}
