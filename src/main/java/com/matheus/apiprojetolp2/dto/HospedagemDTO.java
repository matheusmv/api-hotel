package com.matheus.apiprojetolp2.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.matheus.apiprojetolp2.domain.Hospedagem;
import com.matheus.apiprojetolp2.domain.Quarto;
import com.matheus.apiprojetolp2.domain.Servico;

public class HospedagemDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String idCliente;
	private Instant dataCheckIn;
	private Instant dataCheckOut;
	private Double totalDespesas;

	private Set<Quarto> quartos = new HashSet<>();

	private List<Servico> tarifas = new ArrayList<>();

	public HospedagemDTO() {

	}

	public HospedagemDTO(Hospedagem obj) {
		id = obj.getId();
		idCliente = obj.getIdCliente();
		dataCheckIn = obj.getDataCheckIn();
		dataCheckOut = obj.getDataCheckOut();
		totalDespesas = obj.totalDespesas();
		quartos.addAll(obj.getQuartos());
		tarifas.addAll(obj.getTarifas());
	}

	public String getId() {
		return id;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public Instant getDataCheckIn() {
		return dataCheckIn;
	}

	public Instant getDataCheckOut() {
		return dataCheckOut;
	}

	public Double getTotalDespesas() {
		return totalDespesas;
	}

	public Set<Quarto> getQuartos() {
		return quartos;
	}

	public List<Servico> getTarifas() {
		return tarifas;
	}
}
