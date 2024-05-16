package com.salesianostriana.dam.proyectopepeseguraaca.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
public class RolledBasedSuccesHandler
			implements AuthenticationSuccessHandler{

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	private final String ROLE_ESTUDIANTE_URL = "/web/index";
	private final String ROLE_PROFESOR_URL = "/admin/index";
	private final String ROLE_DEFAULT_URL = "/login?error=Error en el rol asignado";
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		// Determinar el rol de más privilegios, si el usuario tiene más de uno
		String role = getMaxRole(authentication.getAuthorities());

		// En función del rol de más privilegios, redirigir a la URL correcta
		String redirectUrl = determineTargetUrl(role);
		
		if (response.isCommitted()) {
			log.info("Can't redirect");
			return;
		}
		
		redirectStrategy.sendRedirect(request, response, redirectUrl);
		
		
	}
	
	private String getMaxRole(Collection<? extends GrantedAuthority> collection) {
		List<GrantedAuthority> authoritiesList =
				new ArrayList<>(collection);
		
		// Usuario autenticado pero sin rol
		if (authoritiesList.isEmpty())
			return "ROLE_DEFAULT";
		
		return authoritiesList
			.stream()
			.map(GrantedAuthority::getAuthority)
			.sorted((estudiante, profesor) -> 
				role_weight.getOrDefault(profesor, Integer.MIN_VALUE) 
					- role_weight.getOrDefault(estudiante, Integer.MIN_VALUE))
			.findFirst()
			.get();
		
		
	}
	
	 private String determineTargetUrl(String tipo) {
	        return switch(tipo) {
	            case "estudiante" -> "index";
	            case "profesor" -> "indexAdmin";
	            default -> "paginaError";
	        };
	}
	
	private static Map<String, Integer> role_weight = Map.of(
			"ROLE_PROFESOR", 10,
			"ROLE_ESTUDIANTE", 1
			);

}
}
