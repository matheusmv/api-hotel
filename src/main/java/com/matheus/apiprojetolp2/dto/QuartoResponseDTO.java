package com.matheus.apiprojetolp2.dto;

import java.io.Serializable;

import com.matheus.apiprojetolp2.domain.Quarto;

public class QuartoResponseDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	public QuartoResponseDTO() {

	}

	public QuartoResponseDTO(Quarto obj) {
		id = obj.getId();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
