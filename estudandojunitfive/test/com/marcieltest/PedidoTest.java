package com.marcieltest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {
	private PedidoBuilder pedido;

	@BeforeEach
	public void setup() {
		pedido = new PedidoBuilder();
	}

	private void assertResumoPedido(double valorTotal, double desconto) {
		ResumoPedido resumoPedido = pedido.contruir().resumo();
		
		//assertEquals(valorTotal, resumoPedido.getValorTotal(), 0.0001);
		//assertEquals(desconto, resumoPedido.getDesconto(), 0.0001);
		
		assertEquals(new ResumoPedido(valorTotal, desconto), resumoPedido);
	}

	@Test
	void devePermitirAdicionarUmItemNoPedido() throws Exception {
		pedido.comItem(3.0, 5);
	}

	@Test
	void devecalcularValorTotalEDescontoPedidoVazio() throws Exception {
		assertResumoPedido(0.0, 0.0);
	}

	@Test
	void deveCalcularResumParaUmItemSemDesconto() throws Exception {
		pedido.comItem(5.0, 5);
		
		assertResumoPedido(25.0, 0.0);

	}

	@Test
	void deveCalcularResumParaDoisItensSemDesconto() throws Exception {
		pedido.comItem(3.0, 3)
			.comItem(7.0, 3);

		assertResumoPedido(30.0, 0.0);

	}

	@Test
	void deveAplicarDescontoNa1aFaixa() throws Exception {
		pedido.comItem(20.0, 20);
		
		assertResumoPedido(400.0, 16.0);

	}

	@Test
	void deveAplicarDescontoNa2aFaixa() throws Exception {
		pedido.comItem(15.0, 30)
			.comItem(15.0, 30);
		
		assertResumoPedido(900.0, 54.0);

	}

	@Test
	void deveAplicarDescontoNa3aFaixa() throws Exception {
		pedido.comItem(15.0, 30)
			.comItem(15.0, 30)
				.comItem(10.0, 30);
		
		assertResumoPedido(1200.0, 96.0);

	}
	@Test
	void naoAceitarPedidoComItensComQuantidadeNegativas() throws Exception {
		Assertions.assertThrows(QuantidadeItensInvalidosException.class, () -> {pedido.comItem(0.0, -10);
		});
	}
	
	
}
