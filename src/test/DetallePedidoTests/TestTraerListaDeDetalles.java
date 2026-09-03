package test.DetallePedidoTests;

import datos.DetallePedido;
import datos.Pedido;
import negocio.DetallePedidoABM;
import negocio.PedidoABM;

public class TestTraerListaDeDetalles {

	public static void main(String[] args) {

		PedidoABM pedidoABM = new PedidoABM();
		DetallePedidoABM detalleABM = new DetallePedidoABM();

		try {

			Pedido pedido = pedidoABM.traer(5L);

			System.out.println("Detalles del pedido:");

			for (DetallePedido detalle : detalleABM.traer(pedido)) {
				System.out.println(detalle);
			}

		} catch (Exception e) {

			System.out.println("Error: " + e.getMessage());
		}
	}
}
