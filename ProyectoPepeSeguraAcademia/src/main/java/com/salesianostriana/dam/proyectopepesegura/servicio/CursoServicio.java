package com.salesianostriana.dam.proyectopepesegura.servicio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectopepesegura.base.BaseServiceImpl;
import com.salesianostriana.dam.proyectopepesegura.modelo.Curso;
import com.salesianostriana.dam.proyectopepesegura.repositorio.CertificadoRepositorio;
import com.salesianostriana.dam.proyectopepesegura.repositorio.CursoRepositorio;

import jakarta.transaction.Transactional;

@Service
public class CursoServicio extends BaseServiceImpl<Curso, Long, CursoRepositorio>{
	
	@Autowired
	 private CursoRepositorio cursoRepositorio;
	 
	
	public List<Curso> buscarPorIdioma(String nombre) {
		return cursoRepositorio.findByNombreContainsIgnoreCase(nombre);
	}
	

	
	public CursoServicio(CursoRepositorio repo) {
		this.cursoRepositorio = repo;
	}
	
	/**
	 * Inserta un nuevo curso
	 * 
	 * @param El Curso a insertar
	 * @return El Curso ya insertado (con el Id no vacío).
	 */
	public Curso add(Curso c) { 
		return cursoRepositorio.save(c); }
	
	
	/**
	 * Edita un curso, si existe; si no existe, lo inserta como uno nuevo.
	 * @param c
	 * @return
	 */
	public Curso edit(Curso c) {
		return cursoRepositorio.save(c); }

	/**
	 * Elimina el curso
	 * 
	 * @param c
	 */
	public void delete(Curso c) { 
		cursoRepositorio.delete(c); }
	
	/**
	 * Elimina un Curso por su Id
	 * @param id
	 */
	public void delete(long id) { 
		cursoRepositorio.deleteById(id); }
	
	/**
	 * Devuelve todos los cursos
	 * @return
	 */
	public List<Curso> findAll() { 
		return cursoRepositorio.findAll(); }
	
	
	/**
	 * Devuelve un curso en base a su Id
	 * @param id
	 * @return el curso encontrado o <code>null</code>
	 */
	public Curso findById(long id) {
		return cursoRepositorio.findById(id).orElse(null);
	}
	
	
	

}
