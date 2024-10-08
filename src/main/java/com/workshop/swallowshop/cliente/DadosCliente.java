package com.workshop.swallowshop.cliente;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record DadosCliente(
		
		Long id, 
		
		@NotBlank
		String nome, 
		
		@NotBlank
		@Email
		String email, 
		
		@NotBlank
		@Pattern(regexp = "\\d{11}")
		String telefone, 
		
		@NotBlank
		String senha
		
		) {

}
