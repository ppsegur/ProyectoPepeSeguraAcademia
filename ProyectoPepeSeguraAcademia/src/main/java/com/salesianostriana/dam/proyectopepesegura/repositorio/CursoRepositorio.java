package com.salesianostriana.dam.proyectopepesegura.repositorio;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectopepesegura.modelo.Curso;


public interface CursoRepositorio extends JpaRepository<Curso, Long>{

	List<Curso> findByNombreContainsIgnoreCase(String nombre);
	
}
