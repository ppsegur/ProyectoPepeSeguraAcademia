package com.salesianostriana.dam.proyectopepesegura.modelo;

import java.io.Serializable;

import jakarta.persistence.Embeddable;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Embeddable
public class LineaVentaPk implements Serializable{
    
	private static final long serialVersionUID = 1L;


	private Long idVenta;
	private Long linea;

}
