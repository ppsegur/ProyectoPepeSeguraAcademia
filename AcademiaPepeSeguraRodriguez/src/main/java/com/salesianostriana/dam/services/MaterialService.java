package com.salesianostriana.dam.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.model.Material;

import base.BaseServiceImpl;
@Service
public class MaterialService  extends BaseServiceImpl<Material, Long, JpaRepository<Material,Long>>{

}
