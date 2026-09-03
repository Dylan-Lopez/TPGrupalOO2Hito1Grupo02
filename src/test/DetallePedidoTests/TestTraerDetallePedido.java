package test.DetallePedidoTests;

import datos.DetallePedido;
import negocio.DetallePedidoABM;

public class TestTraerDetallePedido {

	public static void main(String[] args) {

		DetallePedidoABM abm = new DetallePedidoABM();

		try {
		DetallePedido detalle = abm.traer(1L);

		System.out.println("DetallePedido:");
		System.out.println(detalle);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
