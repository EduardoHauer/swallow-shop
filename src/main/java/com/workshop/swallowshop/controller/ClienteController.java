package com.workshop.swallowshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.swallowshop.cliente.DadosCliente;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@Valid @RequestBody DadosCliente dados) {
		return ResponseEntity.ok().body(dados);
	}
}
