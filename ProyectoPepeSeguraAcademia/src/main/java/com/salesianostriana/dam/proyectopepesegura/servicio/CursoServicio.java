package com.salesianostriana.dam.proyectopepesegura.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.salesianostriana.dam.proyectopepesegura.base.BaseServiceImpl;
import com.salesianostriana.dam.proyectopepesegura.modelo.Certificado;
import com.salesianostriana.dam.proyectopepesegura.modelo.Curso;
import com.salesianostriana.dam.proyectopepesegura.modelo.Material;

import com.salesianostriana.dam.proyectopepesegura.repositorio.CursoRepositorio;




@Service
public class CursoServicio extends BaseServiceImpl<Curso, Long, CursoRepositorio>{
	
	@Autowired
	 private CursoRepositorio cursoRepositorio;
	 
	@Autowired
	private CertificadoServicio certificadoServicio;
	@Autowired
	private MaterialServicio materialServicio;
	
	public List<Curso> buscarPorIdioma(String nombre) {
		return cursoRepositorio.findByNombreContainsIgnoreCase(nombre);
	}
	public Optional<Curso> finById(Long id){
		return cursoRepositorio.findById(id);
	}
	
	public Curso asignaCertificadoACurso(Curso c,  Long id ) {
		Certificado certificado = c.getCertificado();
		Optional<Curso> cursoAsignado = cursoRepositorio.findById(id);
		if (certificado != null && cursoAsignado.isPresent()) {
		cursoAsignado.get().setCertificado(certificado);
	    certificadoServicio.save(certificado);
		} 
		return c;
		
		
	}
	public Curso asignaMaterialACurso(Curso c, Long id ) {
		Material material = c.getMateriales();
		Optional<Curso> cursoAsignado = cursoRepositorio.findById(id);
		if (material != null && cursoAsignado.isPresent()) {
		cursoAsignado.get().setMateriales(material);
	    materialServicio.save(material);
		} 
		return c;
		
		
	}
	
	
}
