package com.marcieltest.desconto;

public class SemDesconto extends CalculadoraFaixaDesconto {
	
	
	public SemDesconto(CalculadoraFaixaDesconto proximo) {
		super(proximo);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected double calcular(double valorTotal) {
		return 0;
	}

}
