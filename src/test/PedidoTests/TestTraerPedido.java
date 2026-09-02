package test.PedidoTests;

import datos.Pedido;
import negocio.PedidoABM;

public class TestTraerPedido {

	public static void main(String[] args) {
		
	PedidoABM abm = new PedidoABM();
	
	try {

	long idPedido = 2L;

	Pedido pedido = abm.traer(idPedido);

	System.out.println("Pedido:");
	System.out.println(pedido);

	
	}
	catch (Exception e) {
		System.out.println("Error: " + e.getMessage());
	}
}
}