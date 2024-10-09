package com.workshop.swallowshop.produto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DadosProduto(
		
		Long id, 
		
		@NotBlank
		String nome, 
		
		@NotNull
		Double preco, 
		
		@NotNull
		Integer quantidade
		
		) {
}
