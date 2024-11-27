package com.workshop.swallowshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.workshop.swallowshop.cliente.Cliente;
import com.workshop.swallowshop.produto.DadosProduto;
import com.workshop.swallowshop.produto.Produto;
import com.workshop.swallowshop.produto.ProdutosRepositpry;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutosRepositpry repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity cadastraProduto(@Valid @RequestBody DadosProduto dados, UriComponentsBuilder uriBuilder) {
		var produto = new Produto(dados);
		repository.save(produto);
		var uri = uriBuilder.path("/cliente/produto/{id}").buildAndExpand(produto.getId()).toUri();
		return ResponseEntity.created(uri).body(produto);																																																																																																																																																																																																																																															
	}
}
