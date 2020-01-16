package com.matheus.apiprojetolp2.domain.enums;

public enum StatusDoQuarto {
	
	DISPONIVEL(1),
	OCUPADO(2),
	RESERVADO(3),
	MANUTENCAO(4);
	
	private int codigo;
	
	private StatusDoQuarto(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static StatusDoQuarto valueOf(int codigo) {
		for (StatusDoQuarto value : StatusDoQuarto.values()) {
			if (value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Status inválido!");
	}
}
