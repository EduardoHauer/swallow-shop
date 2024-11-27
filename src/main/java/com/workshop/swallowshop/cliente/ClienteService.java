package com.workshop.swallowshop.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PasswordEncoder pc;
	
	public Cliente registraCliente(Cliente cliente) {
		if(clienteRepository.findByEmail(cliente.getEmail()) != null) {
			throw new RuntimeException("Esse email já está em uso");
		}else {
			
			String senhaCript = pc.encode(cliente.getSenha());
			cliente.setSenha(senhaCript);
			
		}
	}
	
	
	
}
