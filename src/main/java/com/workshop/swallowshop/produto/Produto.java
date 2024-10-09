package com.workshop.swallowshop.produto;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "produtos")
@Entity(name = "Produto")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Produto {

	private Long id; 
	private String nome;
	private Double preco;
	private Integer quantidade;
	
	
	public Produto(DadosProduto dados) {
		this.id = dados.id();
		this.nome = dados.nome();
		this.preco = dados.preco();
		this.quantidade = dados.quantidade();
	}
}
