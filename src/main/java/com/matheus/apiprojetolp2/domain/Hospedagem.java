package com.matheus.apiprojetolp2.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "hospedagem")
public class Hospedagem implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String idCliente;
	private Instant dataCheckIn;
	private Instant dataCheckOut;

	private Set<Quarto> quartos = new HashSet<>();

	private List<Tarifa> tarifas = new ArrayList<>();

	public Hospedagem() {

	}

	public Hospedagem(String id, String idCliente, Instant dataCheckIn, Instant dataCheckOut) {
		super();
		this.id = id;
		this.idCliente = idCliente;
		this.dataCheckIn = dataCheckIn;
		this.dataCheckOut = dataCheckOut;
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

	public Instant getDataCheckIn() {
		return dataCheckIn;
	}

	public void setDataCheckIn(Instant dataCheckIn) {
		this.dataCheckIn = dataCheckIn;
	}

	public Instant getDataCheckOut() {
		return dataCheckOut;
	}

	public void setDataCheckOut(Instant dataCheckOut) {
		this.dataCheckOut = dataCheckOut;
	}

	public Set<Quarto> getQuartos() {
		return quartos;
	}

	public void setQuartos(Set<Quarto> quartos) {
		this.quartos = quartos;
	}

	public List<Tarifa> getTarifas() {
		return tarifas;
	}

	public void setTarifas(List<Tarifa> tarifas) {
		this.tarifas = tarifas;
	}

	public Double totalDespesas() {
		Double total = 0.0;

		total += tarifas.stream().mapToDouble(t -> t.getCusto()).sum();
		total += quartos.stream().mapToDouble(q -> q.getCusto()).sum();

		return total;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Hospedagem other = (Hospedagem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
