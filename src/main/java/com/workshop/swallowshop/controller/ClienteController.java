package com.workshop.swallowshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.swallowshop.cliente.DadosCliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@PostMapping
	public ResponseEntity cadastrar(DadosCliente dados) {
		return ResponseEntity.ok().body(dados);
	}
}
