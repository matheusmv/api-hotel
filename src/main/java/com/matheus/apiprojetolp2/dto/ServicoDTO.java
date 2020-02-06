package com.matheus.apiprojetolp2.dto;

import java.io.Serializable;

import com.matheus.apiprojetolp2.domain.Servico;

public class ServicoDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;
	private String descricao;
	private Double custo;

	public ServicoDTO() {

	}

	public ServicoDTO(Servico obj) {
		id = obj.getId();
		nome = obj.getNome();
		descricao = obj.getDescricao();
		custo = obj.getCusto();
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public Double getCusto() {
		return custo;
	}
}
