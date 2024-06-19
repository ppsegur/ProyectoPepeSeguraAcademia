package com.salesianostriana.dam.proyectopepesegura.repositorio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.salesianostriana.dam.proyectopepesegura.modelo.Curso;



public interface CursoRepositorio extends JpaRepository<Curso, Long>{
	//Buscar por idioma
	List<Curso> findByNombreContainsIgnoreCase(String idioma);
	
	//Consulta para buscar cursos comprados 
	List<Curso> findByComprado(boolean comprado);
	
<<<<<<< HEAD
=======

	
>>>>>>> 626378a5c6d4602c390213587b76acf093855e0d
	//Una unión de las dos anteriores
	List<Curso> findByNombreContainsIgnoreCaseAndCompradoFalse(String nombre);
	List<Curso> findByNombreContainsIgnoreCaseAndCompradoTrue(String nombre);
	//Buscar el producto con más ventas
	@Query ("select c from Curso c where c.precio > 30")
	List<Curso> findByCaros();

	Optional<Curso> findById(Long id);

}
