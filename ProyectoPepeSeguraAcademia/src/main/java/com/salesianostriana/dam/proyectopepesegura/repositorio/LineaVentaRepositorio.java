package com.salesianostriana.dam.proyectopepesegura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectopepesegura.modelo.LineaVenta;
import com.salesianostriana.dam.proyectopepesegura.modelo.LineaVentaPk;

public interface LineaVentaRepositorio extends JpaRepository<LineaVenta,LineaVentaPk>{
   //Consulta para solocionar el problema al eliminar un curso asociado a una linea Venta
	boolean existsByCurso_IdCurso(Long idCurso);

}
