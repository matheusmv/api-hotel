package com.matheus.apiprojetolp2.dto;

import com.matheus.apiprojetolp2.domain.Hospedagem;

public class HospedagemResponseDTO {

	private String id;

	public HospedagemResponseDTO() {

	}

	public HospedagemResponseDTO(Hospedagem obj) {
		id = obj.getId();
	}

	public String getId() {
		return id;
	}
}
