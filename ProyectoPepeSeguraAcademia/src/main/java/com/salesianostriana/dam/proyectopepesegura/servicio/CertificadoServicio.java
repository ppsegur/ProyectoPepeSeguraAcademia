package com.salesianostriana.dam.proyectopepesegura.servicio;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectopepesegura.base.BaseServiceImpl;
import com.salesianostriana.dam.proyectopepesegura.modelo.Certificado;
import com.salesianostriana.dam.proyectopepesegura.repositorio.CertificadoRepositorio;

@Service
public class CertificadoServicio extends BaseServiceImpl<Certificado, Long, CertificadoRepositorio> {

	@Autowired
	CertificadoRepositorio certificadoRepositorio;
	
	 public CertificadoServicio(CertificadoRepositorio repo) {
		this.certificadoRepositorio = repo;
	}
	
	/**
	 * Inserta un nuevo curso
	 * 
	 * @param El Curso a insertar
	 * @return El Curso ya insertado (con el Id no vacío).
	 */
	public Certificado add(Certificado c) { 
		return certificadoRepositorio.save(c); }
	
	
	/**
	 * Edita un curso, si existe; si no existe, lo inserta como uno nuevo.
	 * @param c
	 * @return
	 */
	public Certificado edit(Certificado c) {
		return certificadoRepositorio.save(c); }

	/**
	 * Elimina el curso
	 * 
	 * @param c
	 */
	public void delete(Certificado c) {
		certificadoRepositorio.delete(c); }
	
	/**
	 * Elimina un Curso por su Id
	 * @param id
	 */
	public void delete(long id) {
		certificadoRepositorio.deleteById(id); }
	
	/**
	 * Devuelve todos los cursos
	 * @return
	 */
	public List<Certificado> findAll() { 
		return certificadoRepositorio.findAll(); }
	
	
	/**
	 * Devuelve un curso en base a su Id
	 * @param id
	 * @return el curso encontrado o <code>null</code>
	 */
	public Certificado findById(long id) {
		return certificadoRepositorio.findById(id).orElse(null);
	}
	
}
