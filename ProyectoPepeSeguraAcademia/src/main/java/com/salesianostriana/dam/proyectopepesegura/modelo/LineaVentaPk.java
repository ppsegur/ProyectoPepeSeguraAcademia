package com.salesianostriana.dam.proyectopepesegura.modelo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LineaVentaPk implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Venta carrito;
	private long idLv;

}
