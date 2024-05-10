package com.example.academiapepesegurarodriguez.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.academiapepesegurarodriguez.base.BaseServiceImpl;
import com.example.academiapepesegurarodriguez.model.Curso;
@Service
public class CursoService extends BaseServiceImpl<Curso, Long, JpaRepository<Curso,Long>>{

}
