package com.salesianostriana.dam.proyectopepeseguraaca.servicios;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.salesianostriana.dam.proyectopepeseguraaca.model.Usuario;
import com.salesianostriana.dam.proyectopepeseguraaca.reposity.UsuarioRepositorio;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl   implements UserDetailsService{
	
	private final UsuarioRepositorio repo;
	
	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario user = repo.findFirstByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("Error al buscar el usuario"));
        
        return User.withUsername(user.getUsername())
                .password(user.getPassword())
                .roles(user.getTipo())  // Usar el tipo de usuario como rol
                .build();
    }
}
