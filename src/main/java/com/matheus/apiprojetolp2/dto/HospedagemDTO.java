package com.matheus.apiprojetolp2.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.matheus.apiprojetolp2.domain.Hospedagem;

public class HospedagemDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private ClienteSimplesDTO cliente;

	private Set<QuartoDTO> quartos = new HashSet<>();

	public HospedagemDTO() {

	}

	public HospedagemDTO(Hospedagem obj) {
		id = obj.getId();
		cliente = obj.getCliente();
		quartos.addAll(obj.getQuartos());
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public ClienteSimplesDTO getCliente() {
		return cliente;
	}

	public void setCliente(ClienteSimplesDTO cliente) {
		this.cliente = cliente;
	}

	public Set<QuartoDTO> getQuartos() {
		return quartos;
	}

	public void setQuartos(Set<QuartoDTO> quartos) {
		this.quartos = quartos;
	}
}
