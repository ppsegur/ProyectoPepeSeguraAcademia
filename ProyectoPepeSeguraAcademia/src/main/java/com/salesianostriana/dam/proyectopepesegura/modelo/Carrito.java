package com.salesianostriana.dam.proyectopepesegura.modelo;

import java.util.ArrayList;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Builder
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id")
    private Estudiante estudiante;

    @OneToMany(mappedBy = "carrito", cascade = CascadeType.ALL, orphanRemoval = true)
    @Builder.Default
    private List<LineaVenta> lv = new ArrayList<>();

	//LineaVenta
	/**
	 * Método auxiliar para el tratamiento bidireccional de la asociación. Añade un lv
	 * a la colección de lineaVentas de un curso, y asigna a dicho lv este curso como el suyo.
	 * @param a
	 */
	public void addLineaVenta(LineaVenta lv) {
		this.lv.add(lv);
		lv.setCarrito(this);
	}
	
	/**
	 * Método auxiliar para el tratamiento bidireccional de la asociación. Elimina un material
	 * de la colección de materiales de un curso, y desasigna a dicho mateerial el curso, dejándolo como nulo.
	 * @param a
	 */
	public void removeLineaVenta(LineaVenta lv) {
		this.lv.add(lv);
		lv.setCarrito(null);
	
}
}