package com.proyecto1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/index", "/public/**", "/styles.css", "/js/**").permitAll() // Permitir acceso a /index sin autenticación
                                .anyRequest().authenticated() // Requiere autenticación para todas las demás rutas
                )
                .formLogin(formLogin ->
                        formLogin
                                .loginPage("/login") // Página de login personalizada (opcional, si decides usar login)
                                .defaultSuccessUrl("/index", true) // Redirige a /index en caso de éxito
                                .permitAll()
                )
                .logout(logout ->
                        logout
                                .logoutUrl("/logout") // URL para logout
                                .logoutSuccessUrl("/index") // Redirige a /index después de logout
                                .permitAll()
                )
                .csrf(csrf -> csrf.disable()); // Habilitar CSRF por seguridad

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Encriptación de contraseñas
    }
}







