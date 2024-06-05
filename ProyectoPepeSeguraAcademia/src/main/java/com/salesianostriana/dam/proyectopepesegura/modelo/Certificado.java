package com.salesianostriana.dam.proyectopepesegura.modelo;


import jakarta.persistence.Entity;

import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor@AllArgsConstructor
@Builder
@Table(name="CERTIFICADO")
public class Certificado {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCertificado;
	private String nombre;
	
	@OneToOne
	@JoinColumn(name = "curso_id_curso")
	private Curso curso;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_estudiante_certificado"))
	private Estudiante estudiante;


@Override
public String toString() {
    return "Certificado{" +
            "idCertificado=" + idCertificado +
            ", nombre='" + nombre + '\'' +
            ", cursoId=" + (curso != null ? curso.getIdCurso() : "") +
            '}';
}
}