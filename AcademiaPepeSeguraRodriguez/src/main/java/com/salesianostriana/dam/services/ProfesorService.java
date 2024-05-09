package com.salesianostriana.dam.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.model.Profesor;

import base.BaseServiceImpl;

@Service
public class ProfesorService  extends BaseServiceImpl<Profesor, Long, JpaRepository<Profesor,Long>>{

}
