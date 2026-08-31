package test.DetallePedidoTests;

import datos.DetallePedido;

public class TestExcepcionesDetallePedido {

	public static void main(String[] args) {

		System.out.println("=== TEST EXCEPCIONES DETALLE PEDIDO ===\n");

		// 1 - Plato null
		try {
			DetallePedido detalle = new DetallePedido();
			detalle.setPlato(null);

		} catch (Exception e) {
			System.out.println("TEST 1 OK");
			System.out.println(e.getMessage());
		}

		System.out.println();

		// 2 - Cantidad igual a cero
		try {
			DetallePedido detalle = new DetallePedido();
			detalle.setCantidad(0);

		} catch (Exception e) {
			System.out.println("TEST 2 OK");
			System.out.println(e.getMessage());
		}

		System.out.println();

		// 3 - Cantidad negativa
		try {
			DetallePedido detalle = new DetallePedido();
			detalle.setCantidad(-5);

		} catch (Exception e) {
			System.out.println("TEST 3 OK");
			System.out.println(e.getMessage());
		}
	}
}
