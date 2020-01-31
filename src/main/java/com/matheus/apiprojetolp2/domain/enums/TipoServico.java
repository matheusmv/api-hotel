package com.matheus.apiprojetolp2.domain.enums;

public enum TipoServico {

	ALIMENTACAO(1),
	LIMPEZA(2),
	MANUTENCAO(3);
	
	private int codigo;
	
	private TipoServico(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public static TipoServico valueOf(int codigo) {
		for (TipoServico value : TipoServico.values()) {
			if (value.getCodigo() == codigo) {
				return value;
			}
		}
		throw new IllegalArgumentException("Servico inválido!");
	}
}
