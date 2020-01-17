package com.matheus.apiprojetolp2.dto;

import java.io.Serializable;

import com.matheus.apiprojetolp2.dto.enums.TipoServico;

public class TarifaDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer tipoServico;
	private Double custo;

	public TarifaDTO() {

	}

	public TarifaDTO(TipoServico servico, Double custo) {
		setTipoServico(servico);
		this.custo = custo;
	}

	public TipoServico getTipoServico() {
		return TipoServico.valueOf(tipoServico);
	}

	public void setTipoServico(TipoServico servico) {
		if (servico != null) {
			this.tipoServico = servico.getCodigo();
		}
	}

	public Double getCusto() {
		return custo;
	}

	public void setCusto(Double custo) {
		this.custo = custo;
	}
}
