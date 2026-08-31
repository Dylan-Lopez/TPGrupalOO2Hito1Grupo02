package test.DetallePedidoTests;

import datos.DetallePedido;
import datos.Pedido;
import datos.Plato;
import negocio.PedidoABM;
import negocio.PlatoABM;

public class TestAgregarDetallePedido {

	public static void main(String[] args) throws Exception {

		PedidoABM pedidoABM = new PedidoABM();
		PlatoABM platoABM = new PlatoABM();

		Pedido pedido = pedidoABM.traerPedidoYDetalles(1L);
		Plato plato = platoABM.traer(1L);

		DetallePedido detalle = new DetallePedido(plato, 5);

		pedido.agregar(detalle);

		pedidoABM.modificar(pedido);

		System.out.println("DetallePedido agregado correctamente.");
	}
}