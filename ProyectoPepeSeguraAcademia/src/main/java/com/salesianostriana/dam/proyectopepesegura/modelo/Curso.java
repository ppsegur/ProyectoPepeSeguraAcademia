package com.salesianostriana.dam.proyectopepesegura.modelo;

import java.util.ArrayList;

import java.util.List;



import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;


import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;


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

	
	//Booleano para mostrar o no los cursos
	private boolean comprado;
	
	 
public String getNivelDificultad() {
    return nivelDificultad;
}

public void setNivelDificultad(String nivelDificultad) {
    this.nivelDificultad = nivelDificultad;
}
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToOne(mappedBy = "curso",  cascade=CascadeType.ALL, orphanRemoval = true)
	private Certificado certificado;

	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToOne(mappedBy = "curso")
	private Material materiales ;
	
	@ToString.Exclude
	@EqualsAndHashCode.Exclude
	@OneToMany(mappedBy = "curso"  ,cascade = CascadeType.ALL, orphanRemoval = true)
	@Builder.Default
	private List<LineaVenta> lv  = new ArrayList<>();
	
	 @ManyToMany(mappedBy = "cursosFavoritos")
	    private List<Estudiante> estudiantesFavoritos = new ArrayList<>();
	 
    //Metodos helper
	/**
	 * Método auxiliar para el tratamiento bidireccional de la asociación. Añade un lv
	 * a la colección de lineaVentas de un curso, y asigna a dicho lv este curso como el suyo.
	 * @param a
	 */
	public void addCertificado(Certificado c) {
		if(this.certificado!=null) {
			this.setCertificado(c);
			c.setCurso(this);
		}
		
	}
	
	/**
	 * Método auxiliar para el tratamiento bidireccional de la asociación. Elimina un material
	 * de la colección de materiales de un curso, y desasigna a dicho mateerial el curso, dejándolo como nulo.
	 * @param lv
	 */
	public void removeMaterial(Material m) {
		if(this.materiales==null) {
		this.setMateriales(null);
		m.setCurso(null);
		}

}
	/**
	 * Método auxiliar para el tratamiento bidireccional de la asociación. Añade un lv
	 * a la colección de lineaVentas de un curso, y asigna a dicho lv este curso como el suyo.
	 * @param a
	 */
	public void addMaterial(Material m) {
		if(this.materiales!=null) {

		this.setMateriales(materiales);
		m.setCurso(this);
		}
		
	}
	
	/**
	 * Método auxiliar para el tratamiento bidireccional de la asociación. Elimina un material
	 * de la colección de materiales de un curso, y desasigna a dicho mateerial el curso, dejándolo como nulo.
	 * @param lv
	 */
	public void removeCertificado(Certificado c) {
		if(this.certificado==null) {
		this.setCertificado(null);
		c.setCurso(null);
		}
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

	public void removeLineaVenta(LineaVenta lv) {
	    this.lv.remove(lv);
	    lv.setCurso(null);
	}
}