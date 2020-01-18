package com.matheus.apiprojetolp2.dto;

import java.io.Serializable;

import com.matheus.apiprojetolp2.domain.Cliente;

public class ClienteSimplesDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String id;
	private String nome;
	
	public ClienteSimplesDTO() {

	}

	public ClienteSimplesDTO(Cliente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
