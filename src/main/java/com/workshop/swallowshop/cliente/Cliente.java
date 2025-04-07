package com.workshop.swallowshop.cliente;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "clientes")
@Entity(name = "Cliente")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = "id")
public class Cliente implements UserDetails{

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	 
	private String nome;
	private String email;
	private String senha;
	private String telefone;
	private String verificacao;
	private Boolean habilitar;
	
	public Cliente(DadosCliente dados) {
			this.id = dados.id();
			this.nome = dados.nome();
			this.email = dados.email();
			this.senha = dados.senha();
			this.telefone = dados.telefone();
			this.verificacao = dados.verificacao();
			this.habilitar = dados.habilitar();
	 }

	public Cliente(String nome, String email, String senha, Boolean habilitar) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.habilitar = habilitar;
	} 
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return this.habilitar;
	}
	
	@Override
	public String getUsername() {
		return email;
	}
	
	@Override
	public String getPassword() {
		return null;
	}
}
