package com.salesianostriana.dam.proyectopepesegura.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Material {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMaterial;
	private String nombre;
	private String tipo;
	private String url; 
	
	/*@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_curso_material"))
	private Curso curso;*/


}
