package com.workshop.swallowshop.cliente;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "cliente")
@Entity(name = "Cliente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@EqualsAndHashCode(of = "id")
public class Cliente {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	private String nome;
	private String email;
	private String telefone;
	private String senha;
	
	public Cliente(DadosCliente dados) {
			this.id = dados.id();
			this.nome = dados.nome();
			this.email = dados.email();
			this.telefone = dados.telefone();
			this.senha = dados.senha();
	 }
	
}
