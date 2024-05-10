package com.salesianostriana.dam.proyectopepeseguraaca.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.salesianostriana.dam.poryectopepeseguraaca.model.Usuario;
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
