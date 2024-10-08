package com.riwi.SpringBootAssessment.infrastructure.security;

import com.riwi.SpringBootAssessment.domain.model.enums.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final String[] PUBLIC_ENDPOINTS = {"/auth/**", "/swagger-ui/**"};
    private final String[] PRIVATE_ENDPOINTS = {"api/pallets/**","api/loads","api/loads/{id}","api/loads/create"};

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtAuthFilter authFilter;

    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    public AuthenticationManager authManager(AuthenticationConfiguration config) throws Exception{
        return config.getAuthenticationManager();
    }

    public AuthenticationProvider authProvider(){
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();

        authenticationProvider.setPasswordEncoder(this.passwordEncoder());
        authenticationProvider.setUserDetailsService(this.userDetailsService);
        return authenticationProvider;
    }

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(request -> request
                        .requestMatchers(PUBLIC_ENDPOINTS).permitAll()
                        .requestMatchers(PRIVATE_ENDPOINTS).hasAnyAuthority(Role.ADMIN.name())
                        .anyRequest().authenticated())
                .authenticationProvider(authProvider())
                .sessionManagement(sessionManager -> sessionManager
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(this.authFilter,
                        UsernamePasswordAuthenticationFilter.class)
                .build();
    }
}
