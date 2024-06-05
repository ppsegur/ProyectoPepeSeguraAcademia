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
	

	

}
