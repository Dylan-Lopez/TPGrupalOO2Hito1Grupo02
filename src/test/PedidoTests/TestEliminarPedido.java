package test.PedidoTests;

import negocio.PedidoABM;

public class TestEliminarPedido {

	public static void main(String[] args) {

		PedidoABM abm = new PedidoABM();

		long idPedido = 1L;

		try {

			abm.eliminar(idPedido);

			System.out.println("Pedido eliminado correctamente.");

		} catch (Exception e) {

			System.out.println("Error: " + e.getMessage());
		}
	}
}
