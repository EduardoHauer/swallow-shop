package com.workshop.swallowshop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.workshop.swallowshop.cliente.Cliente;
import com.workshop.swallowshop.cliente.ClienteRepository;
import com.workshop.swallowshop.cliente.ClienteResponse;
import com.workshop.swallowshop.cliente.RandomString;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private PasswordEncoder pe;
	
	@Autowired
	private EmailService mailService;
	
	public ClienteResponse registraCliente(Cliente cliente) throws Exception {
		if(clienteRepository.findByEmail(cliente.getEmail()) != null) {
			throw new RuntimeException("Esse email já está em uso");
		}else {
			
			String senhaCript = pe.encode(cliente.getSenha());
			cliente.setSenha(senhaCript);
		
			String randomString = RandomString.randomizadorDeString(49);
			cliente.setVerificacao(randomString);
			cliente.setHabilitar(false);

			Cliente clienteSalvo = clienteRepository.save(cliente);
			
			ClienteResponse clienteResponse = new ClienteResponse(
					clienteSalvo.getId(), clienteSalvo.getNome(),
					clienteSalvo.getEmail(), clienteSalvo.getPassword());
			
			mailService.verificadorDeEmail(cliente);
			return clienteResponse;
	  }
	}
	
	public boolean codigoVerificacao(String verificacao) {
		
		Cliente cliente = clienteRepository.findByVerificacao(verificacao);
		
		if(cliente == null || cliente.isEnabled()) {
			return false;
		}else {
			cliente.setVerificacao(null);
			cliente.setHabilitar(null);
			clienteRepository.save(cliente);
			return true;
		}
	}
}
