package com.workshop.swallowshop.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.JWTVerifier;
import com.workshop.swallowshop.cliente.Cliente;

@Service
public class ServiceToken {

	
	@Value
	  ("${swallowshop.security.token.secret}")
	private String secret;
	
	public String geraToken(Cliente cliente){
		
		var algorithm = Algorithm.HMAC256(secret);
		
		return   JWT.create()
				.withIssuer("SwallowShop")
				.withSubject(cliente.getEmail())
				.withExpiresAt(dadosTempo())
				.sign(algorithm);
	}

	private Instant dadosTempo() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
				
	}

	public String getSubject(String tokenJWT) {
		
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			JWTVerifier verifier = JWT.require(algorithm)
					.withIssuer("SwallowShop")
					.build();
			DecodedJWT jwt = verifier.verify(tokenJWT);
			return jwt.getSubject();
		} catch (JWTVerificationException  e) {
	 }
		return null;
	}
}
