package com.salesianostriana.dam.proyectopepesegura.repositorio;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectopepesegura.modelo.Curso;


public interface CursoRepositorio extends JpaRepository<Curso, Long>{
	//Buscar por idioma
	List<Curso> findByNombreContainsIgnoreCase(String nombre);
	
	//Consulta para buscar cursos comprados 
	List<Curso> findByComprado(boolean comprado);
	
	
	//Una unión de las dos anteriores
	List<Curso> findByNombreContainsIgnoreCaseAndCompradoFalse(String nombre);
	List<Curso> findByNombreContainsIgnoreCaseAndCompradoTrue(String nombre);
}
