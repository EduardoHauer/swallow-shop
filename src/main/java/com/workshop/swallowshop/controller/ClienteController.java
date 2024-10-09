package com.workshop.swallowshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.workshop.swallowshop.cliente.Cliente;
import com.workshop.swallowshop.cliente.ClienteRepository;
import com.workshop.swallowshop.cliente.DadosCliente;
import com.workshop.swallowshop.cliente.DadosInformacionalCliente;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository repository;
	
	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@Valid @RequestBody DadosCliente dados, UriComponentsBuilder uriBuilder) {
		var cliente = new Cliente(dados);
		repository.save(cliente);
		var uri = uriBuilder.path("/cliente/{id}").buildAndExpand(cliente.getId()).toUri();
		return ResponseEntity.created(uri).body(new DadosInformacionalCliente(cliente));
			
	}
}
