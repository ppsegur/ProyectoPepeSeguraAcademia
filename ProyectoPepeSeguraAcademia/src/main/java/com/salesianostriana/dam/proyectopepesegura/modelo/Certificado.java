package com.salesianostriana.dam.proyectopepesegura.modelo;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor@AllArgsConstructor
@Builder
public class Certificado {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCertificado;
	private String fechaExamen;
	private int calificacion;
	
	@ManyToOne
	@JoinColumn(name = "curso_id")
	private Curso curso;

	@ManyToOne
	@JoinColumn(name="id")
	private Estudiante estudiante;
}
