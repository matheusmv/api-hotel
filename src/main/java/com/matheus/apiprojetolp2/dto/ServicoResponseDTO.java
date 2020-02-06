package com.matheus.apiprojetolp2.dto;

import com.matheus.apiprojetolp2.domain.Servico;

public class ServicoResponseDTO {

	private String id;
	private String nome;
	private Double custo;

	public ServicoResponseDTO() {

	}

	public ServicoResponseDTO(Servico obj) {
		id = obj.getId();
		nome = obj.getNome();
		custo = obj.getCusto();
	}

	public String getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public Double getCusto() {
		return custo;
	}
}
