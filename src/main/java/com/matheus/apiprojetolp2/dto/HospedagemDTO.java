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

	public void setId(String id) {
		this.id = id;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	public Date getDataCheckIn() {
		return dataCheckIn;
	}

	public void setDataCheckIn(Date dataCheckIn) {
		this.dataCheckIn = dataCheckIn;
	}

	public Date getDataCheckOut() {
		return dataCheckOut;
	}

	public void setDataCheckOut(Date dataCheckOut) {
		this.dataCheckOut = dataCheckOut;
	}

	public Double getTotalDespesas() {
		return totalDespesas;
	}

	public void setTotalDespesas(Double totalDespesas) {
		this.totalDespesas = totalDespesas;
	}

	public Set<Quarto> getQuartos() {
		return quartos;
	}

	public void setQuartos(Set<Quarto> quartos) {
		this.quartos = quartos;
	}

	public Set<Tarifa> getTarifas() {
		return tarifas;
	}

	public void setTarifas(Set<Tarifa> tarifas) {
		this.tarifas = tarifas;
	}
}
