package com.salesianostriana.dam.proyectopepesegura.excepcion;

public class ExcepcionCeroVentas extends RuntimeException {

	    private static final long serialVersionUID = 1L;

	    public ExcepcionCeroVentas() {
	        super("No existen ventas");
	    }

	    public ExcepcionCeroVentas(String mensaje) {
	        super(mensaje);
	    }
	}

