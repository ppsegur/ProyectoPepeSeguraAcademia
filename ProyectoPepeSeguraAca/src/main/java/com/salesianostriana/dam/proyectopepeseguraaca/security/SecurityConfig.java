package com.salesianostriana.dam.proyectopepeseguraaca.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

	private final UserDetailsService userDetailsService = null;
	private final PasswordEncoder passwordEncoder = null;
	

	@Bean 
	public DaoAuthenticationProvider daoAuthenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(passwordEncoder);
		return provider;
	}
		@Bean
		public AuthenticationManager 
				authenticationManager(HttpSecurity http) throws Exception {
			
			AuthenticationManagerBuilder authBuilder =
					http.getSharedObject(AuthenticationManagerBuilder.class);
			
			return authBuilder
				.authenticationProvider(daoAuthenticationProvider())
				.build();
			
			
		}


		@Bean
		 protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	            .antMatchers("/css/**", "/js/**").permitAll()
	            .antMatchers("/estudiante/**").hasRole("estudiante")
	            .antMatchers("/profesor/**").hasRole("profesor")
	            .anyRequest().authenticated()
	            .and()
	            .formLogin()
	            .loginPage("/login")
	            .successHandler(authenticationSuccessHandler())
	            .permitAll()
	            .and()
	            .logout()
	            .logoutUrl("/logout")
	            .logoutSuccessUrl("/login")
	            .permitAll();
	    }
		
}
