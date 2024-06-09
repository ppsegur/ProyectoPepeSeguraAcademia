package com.salesianostriana.dam.proyectopepesegura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectopepesegura.modelo.LineaVenta;
import com.salesianostriana.dam.proyectopepesegura.modelo.LineaVentaPk;

public interface LineaVentaRepositorio extends JpaRepository<LineaVenta,LineaVentaPk>{

}
