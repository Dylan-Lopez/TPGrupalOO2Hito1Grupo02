package test.PedidoTests;

import datos.DetallePedido;
import datos.Pedido;
import negocio.PedidoABM;

public class TestTraerPedidoYDetalles {

	public static void main(String[] args) {

		PedidoABM abm = new PedidoABM();
		
		try {

		long idPedido = 2L;

		Pedido pedido = abm.traerPedidoYDetalles(idPedido);

		System.out.println("Pedido:");
		System.out.println(pedido);

		System.out.println("\nDetalles del Pedido:");

		for (DetallePedido detalle : pedido.getLstDetalles()) {
			System.out.println(detalle);
		} 
		
		}
		catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
