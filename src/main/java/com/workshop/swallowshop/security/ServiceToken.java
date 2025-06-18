package com.workshop.swallowshop.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.algorithms.Algorithm;
import com.workshop.swallowshop.cliente.Cliente;

import lombok.Getter;

@Getter
@Service
public class ServiceToken {

	
	@Value
	  ("${api.security.token.secret}")
	private String secret;
	
	public String geraToken(Cliente cliente){
		
		var algorithm = Algorithm.HMAC256(secret);
		
		return com.auth0.jwt.JWT.create()
				.withIssuer("SwallowShop")
				.withSubject(cliente.getEmail())
				.withExpiresAt(dadosTempo())
				.sign(algorithm);
	}

	private Instant dadosTempo() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
				
	}

	public String getSubject(String tokenJWT) {
		// TODO Auto-generated method stub
		return null;
	}
}
