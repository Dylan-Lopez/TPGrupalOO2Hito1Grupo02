package test.PedidoTests;

import negocio.PedidoABM;

import java.time.LocalDate;

import datos.Pedido;

public class TestActualizarPedido {
	public static void main(String[] args) {
		
		PedidoABM abm  = new PedidoABM();
		
		try {
			Pedido pedido = abm.traer(3L);
			pedido.setFechaTransaccion(LocalDate.of(2026, 5, 4));
			abm.modificar(pedido);
			
			Pedido pedidomodificado = abm.traer(3L);
			
			 System.out.println(pedidomodificado);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
}
