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
	//1ºra Consulta utilizada
	public List<Curso> buscarPorIdioma(String nombre) {
		return cursoRepositorio.findByNombreContainsIgnoreCase(nombre);
	}
	//2ºda Consulta utilizada 
	public List<Curso> obtenerCursosPorComprado(boolean comprado){
		return cursoRepositorio.findByComprado(comprado);
	}
	//3ºra Consulta utilizada(para que al buscar un curso en el html donde se compra no te aparezacn los comprados
	  public List<Curso> buscarPorNombreNoComprados(String nombre) {
	        return cursoRepositorio.findByNombreContainsIgnoreCaseAndCompradoFalse(nombre);
	    }
	  public List<Curso> buscarPorNombreSiComprados(String nombre) {
	        return cursoRepositorio.findByNombreContainsIgnoreCaseAndCompradoTrue(nombre);
	    }
	public Optional<Curso> finById(Long id){
		return cursoRepositorio.findById(id);
	}
	//USo de la consulta de los mas caros 
	public List<Curso> filtrarPorMasCaros(){
		return cursoRepositorio.findByCaros();
	}

	//Consulta para buscar por id
	 public Curso buscarPorId(Long id) {
		if( cursoRepositorio.findById(id).isPresent()) {
			return cursoRepositorio.findById(id).get();		}
	        
	    
	 return null;
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
