package com.matheus.apiprojetolp2.domain.enums;

public enum TipoCategoria {

	PADRAO(1),
	MASTER(2),
	LUXO(3),
	MASTER_SUPERTIOR(4);
	
	private int codigo;
	
	private TipoCategoria(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static TipoCategoria valueOf(int codigo) {
		for (TipoCategoria value : TipoCategoria.values()) {
			if (value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Tipo inválido!");
	}
}
