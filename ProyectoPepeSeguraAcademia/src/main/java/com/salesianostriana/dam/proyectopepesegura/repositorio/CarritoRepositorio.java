package com.salesianostriana.dam.proyectopepesegura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectopepesegura.modelo.Venta;
import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;


public interface CarritoRepositorio extends JpaRepository<Venta, Long> {
	Venta findByEstudiante(Estudiante estudiante);
}
