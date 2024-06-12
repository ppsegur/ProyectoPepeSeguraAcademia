package com.salesianostriana.dam.proyectopepesegura.modelo;

import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "Material")
public class Material {

	@Id
	@GeneratedValue(generator = "material_seq")
	private long idMaterial;
	
	private String nombre;
	private String tipo;
	private String url; 
	
	@OneToOne
	@JoinColumn(name="id_curso",unique=true )
	private Curso curso;


}
