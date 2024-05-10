package com.example.academiapepesegurarodriguez.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.example.academiapepesegurarodriguez.base.BaseServiceImpl;
import com.example.academiapepesegurarodriguez.model.Profesor;

@Service
public class ProfesorService  extends BaseServiceImpl<Profesor, Long, JpaRepository<Profesor,Long>>{

}
