package com.matheus.apiprojetolp2.dto;

import com.matheus.apiprojetolp2.dto.enums.TipoCategoria;

public class CategoriaDTO {

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
