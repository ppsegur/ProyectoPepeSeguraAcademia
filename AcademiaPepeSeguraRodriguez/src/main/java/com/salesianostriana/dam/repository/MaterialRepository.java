package com.salesianostriana.dam.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.model.Material;

public interface MaterialRepository extends JpaRepository<Material, Long> {

}
