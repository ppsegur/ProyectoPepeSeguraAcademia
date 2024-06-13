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
                        (authz) -> authz.requestMatchers("/css/**", "/js/**","/img/**", "/h2-console/**").permitAll()
                        .requestMatchers("/user/nuevoEstudiante", "/user/nuevoEstudiante/submit","/").permitAll()
                        .requestMatchers("/admin/**").hasRole("ADMIN")

                        .requestMatchers("/carrito/checkout").permitAll()
                                .anyRequest().authenticated())
  
                .formLogin((loginz) -> loginz
                        .loginPage("/login").defaultSuccessUrl("/").permitAll())//**.rememberMe(rememberMe -> rememberMe.key("uniqueAndSecret").tokenValiditySeconds(100))
                //REMEMBER ME 
                //Se supone que en la linea anterior debemos agregar .rememberMe(rememberMe -> rememberMe.Key("uniqueAndSecret").tokenValiditySeconds(86400)))
                // tambien añade despues de esa linea otra -logout(logout -> logout.deleteCookies('JSESSIONID")
                //	En el formulario en <td>Remember Me;</td> debajo pondremos <td><input type ="checkbox", name ="remember-me" 
                //Fuente==  https://www.baeldung.com/spring-security-remember-me
                .logout((logoutz) -> logoutz
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login")
                        //************.deleteCookies("JSESSIONID")
                        .permitAll());
        // Añadimos esto para poder seguir accediendo a la consola de H2
        // con Spring Security habilitado.
        http.csrf(csrfz -> csrfz.disable());
        http.headers(headersz -> headersz
                .frameOptions(frameOptionsz -> frameOptionsz.disable()));

        return http.build();
    }

}
