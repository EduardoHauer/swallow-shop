package com.workshop.swallowshop.cliente;

public record DadosInformacionalCliente(String nome, String email, String senha) {

	public DadosInformacionalCliente(DadosCliente dados) {
		this(dados.nome(), dados.email(), dados.senha());
	}

}
