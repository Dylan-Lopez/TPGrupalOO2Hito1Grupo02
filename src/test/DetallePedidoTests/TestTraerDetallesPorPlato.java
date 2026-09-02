package test.DetallePedidoTests;

import datos.DetallePedido;
import negocio.DetallePedidoABM;

public class TestTraerDetallesPorPlato {

	public static void main(String[] args) {

		DetallePedidoABM abm = new DetallePedidoABM();

		try {

			System.out.println("--- Detalles que contienen el plato ---");

			for (DetallePedido detalle : abm.traerPorPlato(2L)) {
				System.out.println(detalle);
			}

		} catch (Exception e) {

			System.out.println("Error: " + e.getMessage());
		}
	}
}