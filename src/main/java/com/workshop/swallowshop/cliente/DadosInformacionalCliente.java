package com.workshop.swallowshop.cliente;

public record DadosInformacionalCliente(Long id, String nome, String email, String telefone, String senha) {

	public DadosInformacionalCliente(Cliente cliente) {
		this(cliente.getId(), cliente.getNome(), cliente.getEmail(),cliente.getTelefone(), cliente.getSenha());
	}

}
