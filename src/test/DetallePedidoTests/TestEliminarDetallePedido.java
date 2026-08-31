package test.DetallePedidoTests;

import negocio.DetallePedidoABM;

public class TestEliminarDetallePedido {

	public static void main(String[] args) {

		DetallePedidoABM abm = new DetallePedidoABM();

		long idDetalle = 1L;

		abm.eliminar(idDetalle);

		System.out.println(
				"DetallePedido eliminado correctamente."
		);
	}
}