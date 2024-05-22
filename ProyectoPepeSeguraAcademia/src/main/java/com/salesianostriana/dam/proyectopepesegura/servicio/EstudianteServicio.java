package com.salesianostriana.dam.proyectopepesegura.servicio;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectopepesegura.base.BaseServiceImpl;
import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;
import com.salesianostriana.dam.proyectopepesegura.repositorio.EstudianteRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EstudianteServicio extends BaseServiceImpl<Estudiante, Long, EstudianteRepositorio> {
	 
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	@Autowired
	private EstudianteRepositorio estudianteRepositorio;

    @Override
    public Estudiante save(Estudiante e) {
    e.setPassword(passwordEncoder.encode(e.getPassword()));
    e.setNoEstudiante(false);
        return estudianteRepositorio.save(e);
    }
	
	}
