package com.matheus.apiprojetolp2.domain;

import java.io.Serializable;

import com.matheus.apiprojetolp2.domain.enums.TipoCategoria;

public class Categoria implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Integer tipoCategoria;

	public Categoria() {

	}

	public Categoria(TipoCategoria categoria) {
		setCategoria(categoria);
	}

	public TipoCategoria getCategoria() {
		return TipoCategoria.valueOf(tipoCategoria);
	}

	public void setCategoria(TipoCategoria categoria) {
		if (categoria != null) {
			this.tipoCategoria = categoria.getCodigo();
		}
	}
}
