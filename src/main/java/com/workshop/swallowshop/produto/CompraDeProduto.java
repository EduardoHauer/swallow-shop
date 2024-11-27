package com.workshop.swallowshop.produto;

import org.springframework.http.ResponseEntity;
import org.springframework.web.util.UriComponentsBuilder;

import com.workshop.swallowshop.cliente.Cliente;

public class CompraDeProduto {

	public ResponseEntity compraDeProduto(Cliente cliente, UriComponentsBuilder ub) {
		return ResponseEntity.ok().body(null);
	}
}
