package com.matheus.apiprojetolp2.domain;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.matheus.apiprojetolp2.domain.enums.StatusDoQuarto;
import com.matheus.apiprojetolp2.domain.enums.TipoCategoria;

@Document(collection = "quarto")
public class Quarto implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Integer tipoCategoria;
	private Integer statusDoQuarto;
	private Double custo;

	public Quarto() {

	}

	public Quarto(String id, TipoCategoria categoria, StatusDoQuarto status, Double custo) {
		super();
		this.id = id;
		setCategoria(categoria);
		setStatus(status);
		this.custo = custo;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public TipoCategoria getCategoria() {
		return TipoCategoria.valueOf(tipoCategoria);
	}

	public void setCategoria(TipoCategoria categoria) {
		if (categoria != null) {
			this.tipoCategoria = categoria.getCodigo();
		}
	}

	public StatusDoQuarto getStatus() {
		return StatusDoQuarto.valueOf(statusDoQuarto);
	}

	public void setStatus(StatusDoQuarto status) {
		if (status != null) {
			this.statusDoQuarto = status.getCodigo();
		}
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
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
		Quarto other = (Quarto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
}
