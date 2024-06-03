package com.salesianostriana.dam.proyectopepesegura.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "MATERIAL")
public class Material {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idMaterial;
	private String nombre;
	private String tipo;
	private String url; 
	
	@ManyToOne
	@JoinColumn(name="curso_id_curso" )
	private Curso curso;

    @Override
    public String toString() {
        return "Material{" +
                "id=" + idMaterial +
                ", nombre='" + nombre + '\'' +
                 ", tipo='" + tipo + '\'' +
                 ", url='" + url + '\'' +
                '}';
    }
}
