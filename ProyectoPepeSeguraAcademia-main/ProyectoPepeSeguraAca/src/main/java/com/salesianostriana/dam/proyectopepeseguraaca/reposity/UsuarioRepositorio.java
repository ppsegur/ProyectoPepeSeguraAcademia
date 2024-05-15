package com.salesianostriana.dam.proyectopepeseguraaca.reposity;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salesianostriana.dam.proyectopepeseguraaca.model.Usuario;

public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {

}
