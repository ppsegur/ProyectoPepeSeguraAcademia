package com.salesianostriana.dam.poryectopepeseguraaca.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity@Data@NoArgsConstructor@AllArgsConstructor
@Builder
public class Curso {

	@Id
	@GeneratedValue()
	private long idCurso;
	
	private String nombre;
	private String nivelDificultad;
	//Lob
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
