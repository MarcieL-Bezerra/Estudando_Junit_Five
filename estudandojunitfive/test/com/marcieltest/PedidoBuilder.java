package com.marcieltest;

import com.marcieltest.desconto.CalculadoraDescontoPrimeiraFaixa;
import com.marcieltest.desconto.CalculadoraDescontoSegundaFaixa;
import com.marcieltest.desconto.CalculadoraDescontoTerceiraFaixa;
import com.marcieltest.desconto.CalculadoraFaixaDesconto;
import com.marcieltest.desconto.SemDesconto;

public class PedidoBuilder {
	private Pedido instancia;

	public PedidoBuilder() {
		CalculadoraFaixaDesconto calculadoraFaixaDesconto = 
				new CalculadoraDescontoTerceiraFaixa(
						new CalculadoraDescontoSegundaFaixa(
								new CalculadoraDescontoPrimeiraFaixa(
										new SemDesconto(null))));

		instancia = new Pedido(calculadoraFaixaDesconto);
	}

	public PedidoBuilder comItem(double valorUnitario, int quantidade) {
		instancia.adicionarItem(new ItemPedido("Gerado", valorUnitario, quantidade));

		return this;

	}

	public Pedido contruir() {
		return instancia;
	}

}
