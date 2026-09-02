package test.DetallePedidoTests;

import datos.Pedido;
import datos.Plato;
import negocio.DetallePedidoABM;
import negocio.PedidoABM;
import negocio.PlatoABM;

public class TestAgregarDetallePedido {

	public static void main(String[] args) {

		PedidoABM pedidoABM = new PedidoABM();
		PlatoABM platoABM = new PlatoABM();
		DetallePedidoABM detalleABM = new DetallePedidoABM();

		try {

			// Traemos el pedido existente
			Pedido pedido = pedidoABM.traer(5L);

			// Traemos el plato existente
			Plato plato = platoABM.traer(2L);

			// Agregamos el detalle directamente
			int idDetalle = detalleABM.agregar(plato, 5, pedido);

			System.out.println("DetallePedido agregado correctamente. ID: " + idDetalle);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}