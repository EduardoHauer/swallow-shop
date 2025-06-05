package com.workshop.swallowshop.cliente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface ClienteRepository extends JpaRepository<Cliente, Long>{

	UserDetails findByEmail(String email);
	
	Cliente findByVerificacao(String verificacao);
	
}
