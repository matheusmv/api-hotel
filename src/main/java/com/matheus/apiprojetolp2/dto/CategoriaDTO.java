package com.matheus.apiprojetolp2.dto;

import java.io.Serializable;

import com.matheus.apiprojetolp2.dto.enums.TipoCategoria;

public class CategoriaDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	private Integer tipoCategoria;

	public CategoriaDTO() {

	}

	public CategoriaDTO(TipoCategoria categoria) {
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
