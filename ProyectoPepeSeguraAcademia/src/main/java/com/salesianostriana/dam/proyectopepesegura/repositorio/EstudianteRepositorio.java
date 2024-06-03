package com.salesianostriana.dam.proyectopepesegura.repositorio;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long>{
	
	
	Optional<Estudiante> findFirstByUsername(String username);
	
}
