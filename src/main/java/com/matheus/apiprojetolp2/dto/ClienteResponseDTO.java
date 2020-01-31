package com.matheus.apiprojetolp2.dto;

import java.io.Serializable;

import com.matheus.apiprojetolp2.domain.Cliente;

public class ClienteResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;

	public ClienteResponseDTO() {

	}

	public ClienteResponseDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
