package com.salesianostriana.dam.proyectopepesegura.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectopepesegura.modelo.Material;

public interface MaterialRepositorio extends JpaRepository<Material, Long>{

	List<Material> findByCursoIdCurso(Long idcurso);

}
