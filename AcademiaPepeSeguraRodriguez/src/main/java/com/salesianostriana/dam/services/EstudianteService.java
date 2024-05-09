package com.salesianostriana.dam.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.model.Estudiante;

import base.BaseServiceImpl;

@Service
public class EstudianteService  extends BaseServiceImpl<Estudiante, Long, JpaRepository<Estudiante,Long>>{

}
