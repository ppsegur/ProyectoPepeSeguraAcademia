package com.salesianostriana.dam.proyectopepesegura.modelo;

import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Entity 
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name="CURSO")
public class Curso {
		
	@Id
	@GeneratedValue
	private long idCurso;
	
	private String nombre;
	private String nivelDificultad;
	//Lob
	private String duracion;
	private double precio;

public String getNivelDificultad() {
    return nivelDificultad;
}

public void setNivelDificultad(String nivelDificultad) {
    this.nivelDificultad = nivelDificultad;
}
	
	
	@OneToOne(mappedBy = "curso", cascade=CascadeType.ALL, orphanRemoval = true)
	private Certificado certificado;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "curso"  ,cascade = CascadeType.ALL, orphanRemoval = true)
	@Builder.Default
	private List<Material> materiales = new ArrayList<>();
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "curso"  ,cascade = CascadeType.ALL, orphanRemoval = true)
	@Builder.Default
	private List<LineaVenta> lv  = new ArrayList<>();
		
	 
	
    //Metodos helper
	/**
	 * Método auxiliar para el tratamiento bidireccional de la asociación. Añade un material
	 * a la colección de materiales de un curso, y asigna a dicho material este curso como el suyo.
	 * @param a
	 */
	public void addMaterial(Material m) {
		this.materiales.add(m);
		m.setCurso(this);
	}
	
	/**
	 * Método auxiliar para el tratamiento bidireccional de la asociación. Elimina un material
	 * de la colección de materiales de un curso, y desasigna a dicho mateerial el curso, dejándolo como nulo.
	 * @param a
	 */
	public void removeMaterial(Material m) {
		this.materiales.add(m);
		m.setCurso(null);
	}
	//LineaVenta
	/**
	 * Método auxiliar para el tratamiento bidireccional de la asociación. Añade un lv
	 * a la colección de lineaVentas de un curso, y asigna a dicho lv este curso como el suyo.
	 * @param a
	 */
	public void addLineaVenta(LineaVenta lv) {
		this.lv.add(lv);
		lv.setCurso(this);
	}
	
	/**
	 * Método auxiliar para el tratamiento bidireccional de la asociación. Elimina un material
	 * de la colección de materiales de un curso, y desasigna a dicho mateerial el curso, dejándolo como nulo.
	 * @param a
	 */
	public void removeLineaVenta(LineaVenta lv) {
		this.lv.add(lv);
		lv.setCurso(null);
	
}
}