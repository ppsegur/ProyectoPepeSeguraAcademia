package com.example.academiapepesegurarodriguez.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.academiapepesegurarodriguez.base.BaseServiceImpl;
import com.example.academiapepesegurarodriguez.model.Estudiante;

@Service
public class EstudianteService  extends BaseServiceImpl<Estudiante, Long, JpaRepository<Estudiante,Long>>{

}
