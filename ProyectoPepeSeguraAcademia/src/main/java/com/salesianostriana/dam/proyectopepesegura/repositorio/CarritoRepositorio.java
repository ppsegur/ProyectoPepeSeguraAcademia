package com.salesianostriana.dam.proyectopepesegura.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectopepesegura.modelo.Carrito;
import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;


public interface CarritoRepositorio extends JpaRepository<Carrito, Long> {
	Carrito findByEstudiante(Estudiante estudiante);
}
