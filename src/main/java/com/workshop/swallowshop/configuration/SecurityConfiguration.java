package com.workshop.swallowshop.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.workshop.swallowshop.security.SecurityFilter;

@Configuration
public class SecurityConfiguration {
	
	@Autowired
	private SecurityFilter securityFilterChain;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
				
		return http
						.csrf(csrf ->csrf.disable())
						.sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
						.authorizeHttpRequests(req -> {
							req
								.requestMatchers("/clientes/cadastro", "/clientes/verify").permitAll()
								.anyRequest().authenticated();
						}).addFilterBefore(securityFilterChain, UsernamePasswordAuthenticationFilter.class)
						.build();
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}
	
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
}
