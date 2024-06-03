package com.salesianostriana.dam.proyectopepesegura.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.proyectopepesegura.modelo.Curso;

@Repository
public interface CursoRepositorio extends JpaRepository<Curso, Long>{
	  
	@Query("SELECT c FROM Curso c WHERE c.idioma = ingles")
    List<Curso> findCursosByIdioma(@Param("idioma") String idioma);
}
