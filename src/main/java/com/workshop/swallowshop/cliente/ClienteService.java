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
	private PasswordEncoder pe;
	
	public ClienteResponse registraCliente(Cliente cliente) {
		if(clienteRepository.findByEmail(cliente.getEmail()) != null) {
			throw new RuntimeException("Esse email já está em uso");
		}else {
			
			String senhaCript = pe.encode(cliente.getSenha());
			cliente.setSenha(senhaCript);
		
			String randomString = RandomString.randomizadorDeString(49);
			//cliente.setVerificacao(randomString);
			cliente.setHabilitar(false);

			Cliente clienteSalvo = clienteRepository.save(cliente);
			
			ClienteResponse clienteResponse = new ClienteResponse(
					clienteSalvo.getId(), clienteSalvo.getNome(),
					clienteSalvo.getEmail(), clienteSalvo.getPassword());
			
			return clienteResponse;
	  }
	}
}
