package com.salesianostriana.dam.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.model.Curso;

import base.BaseServiceImpl;
@Service
public class CursoService extends BaseServiceImpl<Curso, Long, JpaRepository<Curso,Long>>{

}
