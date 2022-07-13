package com.betinsk.mc.domain;

import com.betinsk.mc.domain.enums.EstadoPagamento;

public class PagamentoComCartao extends Pagamento {
	
	private Integer numeroDeParcelas;

	public PagamentoComCartao() {

	}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Integer numeroDeParcelas) {
		super(id, estado);
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	
	
	
}
