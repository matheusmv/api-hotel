package com.matheus.apiprojetolp2.dto;

import java.io.Serializable;

public class TelefoneDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codigo;
	private String ddd;
	private String numero;

	public TelefoneDTO() {

	}

	public TelefoneDTO(String codigo, String ddd, String numero) {
		super();
		this.codigo = codigo;
		this.ddd = ddd;
		this.numero = numero;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}
}
