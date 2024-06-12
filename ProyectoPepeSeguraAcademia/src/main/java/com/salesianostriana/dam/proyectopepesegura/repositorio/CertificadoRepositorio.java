package com.salesianostriana.dam.proyectopepesegura.repositorio;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectopepesegura.modelo.Certificado;


public interface CertificadoRepositorio extends JpaRepository<Certificado, Long>{
	
	List<Certificado> findByCursoIdCurso(Long idcurso);
}
