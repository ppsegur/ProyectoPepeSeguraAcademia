package com.salesianostriana.dam.proyectopepesegura.servicio;

import java.util.List;

import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectopepesegura.base.BaseServiceImpl;
import com.salesianostriana.dam.proyectopepesegura.modelo.Curso;
import com.salesianostriana.dam.proyectopepesegura.repositorio.CursoRepositorio;

@Service
public class CursoServicio extends BaseServiceImpl<Curso, Long, CursoRepositorio>{
	
	private  CursoRepositorio cursoRepositorio;

	    public  CursoServicio(CursoRepositorio cursoRepository) {
	        this.cursoRepositorio = cursoRepository;
	    }

	    public List<Curso> obtenerCursosDeIngles() {
	        return cursoRepositorio.findCursosByIdioma("Inglés");
	    }
}
