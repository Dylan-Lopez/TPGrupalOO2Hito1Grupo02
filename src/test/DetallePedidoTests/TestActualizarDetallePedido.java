package test.DetallePedidoTests;

import datos.DetallePedido;
import negocio.DetallePedidoABM;

public class TestActualizarDetallePedido {

	public static void main(String[] args) throws Exception {

		DetallePedidoABM abm = new DetallePedidoABM();

		// Traer el detalle a modificar
		DetallePedido detalle = abm.traer(1L);

		System.out.println("Detalle antes de modificar:");
		System.out.println(detalle);

		// Modificar la cantidad
		detalle.setCantidad(5);

		// Actualizar
		abm.modificar(detalle);

		// Traer nuevamente para comprobar
		DetallePedido detalleModificado = abm.traer(1L);

		System.out.println("\nDetalle modificado:");
		System.out.println(detalleModificado);
	}
}