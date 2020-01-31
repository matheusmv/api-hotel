package com.matheus.apiprojetolp2.domain;

import java.io.Serializable;

public class Telefone implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codigo;
	private String ddd;
	private String numero;

	public Telefone() {

	}

	public Telefone(String codigo, String ddd, String numero) {
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
