package com.workshop.swallowshop.cliente;

public record DadosInformacionalCliente(String nome, String email, String senha) {

	public DadosInformacionalCliente(Cliente cliente) {
		this( cliente.getNome(), cliente.getEmail(), cliente.getSenha());
	}

	
	public Cliente toModel() {
		return new Cliente(nome, email, senha);
	}
}
