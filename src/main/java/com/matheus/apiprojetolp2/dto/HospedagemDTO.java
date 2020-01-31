package com.matheus.apiprojetolp2.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.matheus.apiprojetolp2.domain.Hospedagem;
import com.matheus.apiprojetolp2.domain.Quarto;
import com.matheus.apiprojetolp2.domain.Tarifa;

public class HospedagemDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private String idCliente;
	private Date dataCheckIn;
	private Date dataCheckOut;
	private Double totalDespesas;

	private Set<Quarto> quartos = new HashSet<>();

	private Set<Tarifa> tarifas = new HashSet<>();

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

	public Date getDataCheckIn() {
		return dataCheckIn;
	}

	public Date getDataCheckOut() {
		return dataCheckOut;
	}

	public Double getTotalDespesas() {
		return totalDespesas;
	}

	public Set<Quarto> getQuartos() {
		return quartos;
	}

	public Set<Tarifa> getTarifas() {
		return tarifas;
	}
}
