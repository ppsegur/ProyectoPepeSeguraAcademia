package com.salesianostriana.dam.proyectopepesegura.repositorio;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;

public interface EstudianteRepositorio extends JpaRepository<Estudiante, Long>{
	
	
	Optional<Estudiante> findFirstByUsername(String username);
	
	//Consulta para favoritos
	Estudiante findByUsername(String username);
	
}
