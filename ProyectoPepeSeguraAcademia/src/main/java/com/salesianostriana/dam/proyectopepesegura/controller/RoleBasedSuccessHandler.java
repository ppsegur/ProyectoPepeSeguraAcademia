package com.salesianostriana.dam.proyectopepesegura.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class RoleBasedSuccessHandler implements AuthenticationSuccessHandler {

    private static final String ROLE_USER_URL = "/";
    private static final String ROLE_ADMIN_URL = "/admin/Index";
    private static final String ROLE_DEFAULT_URL = "/login?error=Error en el rol asignado";

    private static final Map<String, Integer> role_weight = Map.of(
            "ROLE_ADMIN", 10,
            "ROLE_USER", 1
    );

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        String role = getMaxRole(authentication.getAuthorities());
        String redirectUrl = determineTargetUrl(role);

        if (response.isCommitted()) {
            return;
        }

        response.sendRedirect(request.getContextPath() + redirectUrl);
    }

    private String getMaxRole(Collection<? extends GrantedAuthority> authorities) {
        return authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .max((role1, role2) -> role_weight.getOrDefault(role2, Integer.MIN_VALUE) -
                        role_weight.getOrDefault(role1, Integer.MIN_VALUE))
                .orElse("ROLE_DEFAULT");
    }

    private String determineTargetUrl(String role) {
        return switch (role) {
            case "ROLE_ADMIN" -> ROLE_ADMIN_URL;
            case "ROLE_USER" -> ROLE_USER_URL;
            default -> ROLE_DEFAULT_URL;
        };
    }
}
