package test.DetallePedidoTests;

import negocio.DetallePedidoABM;

public class TestEliminarDetallePedido {

	public static void main(String[] args) {

		DetallePedidoABM abm = new DetallePedidoABM();

		try {

			long idDetalle = 3L;

			abm.eliminar(idDetalle);

			System.out.println("Detalle_Pedido eliminado correctamente.");

		} catch (Exception e) {

			System.out.println("Error: " + e.getMessage());
		}
	}
}