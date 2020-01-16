package com.matheus.apiprojetolp2.dto;

import java.io.Serializable;

import com.matheus.apiprojetolp2.domain.Cliente;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String name;
	private String email;
	private EnderecoDTO endereco;
	private TelefoneDTO numero;
	
	public ClienteDTO() {
		
	}

	public ClienteDTO(Cliente obj) {
		this.id = obj.getId();
		this.name = obj.getNome();
		this.email = obj.getEmail();
		this.endereco = obj.getEndereco();
		this.numero = obj.getTelefone();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public TelefoneDTO getNumero() {
		return numero;
	}

	public void setNumero(TelefoneDTO numero) {
		this.numero = numero;
	}

	public EnderecoDTO getEndereco() {
		return endereco;
	}

	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}
}
