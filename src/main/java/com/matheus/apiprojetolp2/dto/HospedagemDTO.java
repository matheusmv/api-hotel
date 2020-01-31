package com.matheus.apiprojetolp2.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.matheus.apiprojetolp2.domain.Hospedagem;
import com.matheus.apiprojetolp2.domain.Quarto;

public class HospedagemDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private ClienteSimplesDTO cliente;
	private Date dataCheckIn;
	private Date dataCheckOut;

	private Set<Quarto> quartos = new HashSet<>();

	public HospedagemDTO() {

	}

	public HospedagemDTO(Hospedagem obj) {
		id = obj.getId();
		cliente = obj.getCliente();
		dataCheckIn = obj.getDataCheckIn();
		dataCheckOut = obj.getDataCheckOut();
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

	public Set<Quarto> getQuartos() {
		return quartos;
	}

	public void setQuartos(Set<Quarto> quartos) {
		this.quartos = quartos;
	}
}
