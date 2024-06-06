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
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="CERTIFICADO")
public class Certificado {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCertificado;
	private String nombreC;
	
	@OneToOne
	@JoinColumn(name = "idCertificado", unique = true )
	private Curso curso;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_estudiante_certificado"))
	private Estudiante estudiante;





}