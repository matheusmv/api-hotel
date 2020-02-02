package com.matheus.apiprojetolp2.dto;

import java.io.Serializable;

import com.matheus.apiprojetolp2.domain.Cliente;
import com.matheus.apiprojetolp2.domain.Telefone;

public class ClienteDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;
	private String email;
	private String senha;
	private String cpf;
	private String rg;
	private Telefone telefone;

	public ClienteDTO() {

	}

	public ClienteDTO(Cliente obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.cpf = obj.getCpf();
		this.rg = obj.getRg();
		this.telefone = obj.getTelefone();
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public String getCpf() {
		return cpf;
	}

	public String getRg() {
		return rg;
	}

	public Telefone getTelefone() {
		return telefone;
	}
}
