package com.workshop.swallowshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.workshop.swallowshop.cliente.Cliente;
import com.workshop.swallowshop.cliente.ClienteRepository;
import com.workshop.swallowshop.cliente.ClienteResponse;
import com.workshop.swallowshop.cliente.DadosInformacionalCliente;
import com.workshop.swallowshop.service.ClienteService;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private ClienteService clienteService;
	
	@PostMapping
	@Transactional
	public ResponseEntity<ClienteResponse> cadastrar(@RequestBody @Valid DadosInformacionalCliente dados) throws Exception {
		Cliente cliente = dados.toModel();
		ClienteResponse clienteSalvo = clienteService.registraCliente(cliente);
		return ResponseEntity.created(null).body(clienteSalvo);	
	}
	
	@GetMapping("/verify")
	public String verificaUsuario(@Param("code") String code) {
		
		if(clienteService.codigoVerificacao(code)) {
			return "vrificacao_realizada";
		} else {
			
			return "verificacao_falhou";
		}
		
	} 
	
}
