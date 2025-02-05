package com.workshop.swallowshop.cliente;

public record DadosInformacionalCliente(String nome, String email, String senha, Boolean habilitar) {

	public DadosInformacionalCliente(Cliente cliente) {
		this( cliente.getNome(), cliente.getEmail(), cliente.getSenha(), cliente.getHabilitar());
	}

	
	public Cliente toModel() {
		return new Cliente(nome, email, senha, false);
	}
}
