package com.salesianostriana.dam.proyectopepesegura.security;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.salesianostriana.dam.proyectopepesegura.modelo.Estudiante;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final UserDetailsService userDetailsService;
	private final PasswordEncoder passwordEncoder;


    @Bean
    DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		return provider;
	}

    @Bean
    AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
		
		AuthenticationManagerBuilder authBuilder =
				http.getSharedObject(AuthenticationManagerBuilder.class);
		
		return authBuilder
			.authenticationProvider(daoAuthenticationProvider())
			.build();
		
		
}
	@Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(
                        (authz) -> authz.requestMatchers("/css/**", "/js/**","/img/**", "/h2-console/**","/index/**").permitAll()
                                .requestMatchers("/admin/**").hasRole("NO_ESTUIDANTE")
                                .anyRequest().authenticated())
  
                .formLogin((loginz) -> loginz
                        .loginPage("/login").defaultSuccessUrl("/index",true).permitAll())
                .logout((logoutz) -> logoutz
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        .permitAll());
        // Añadimos esto para poder seguir accediendo a la consola de H2
        // con Spring Security habilitado.
        http.csrf(csrfz -> csrfz.disable());
        http.headers(headersz -> headersz
                .frameOptions(frameOptionsz -> frameOptionsz.disable()));

        return http.build();
    }

}
