package com.salesianostriana.dam.proyectopepesegura.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectopepesegura.base.BaseServiceImpl;
import com.salesianostriana.dam.proyectopepesegura.modelo.Curso;
import com.salesianostriana.dam.proyectopepesegura.repositorio.CursoRepositorio;

@Service
public class CursoServicio extends BaseServiceImpl<Curso, Long, CursoRepositorio>{
	
	@Autowired
	 private CursoRepositorio cursoRepositorio;
	 
	public List<Curso> buscarPorIdiomaOrnivel(String nombre, String nivelDificultad) {
		return cursoRepositorio.findByNombreContainsIgnoreCaseOrNivelDificultadContainsIgnoreCase(nombre, nivelDificultad);
	}
}
