/*

package test.PedidoTests;

import java.time.LocalDate;

import datos.Pedido;
import negocio.PedidoABM;
import negocio.UnidadVentaABM;
import datos.UnidadVenta;

public class TestActualizarPedido {
	public static void main(String[] args) throws Exception {
		
		PedidoABM abm = new PedidoABM();
		Pedido p1 = abm.traer(1L);
		System.out.printf("Pedido a Modificar: %s\n\n", p1);
		
		p1.setFechaTransaccion(LocalDate.of(2025, 3, 5));
		
		UnidadVentaABM abm2 = new UnidadVentaABM();
		UnidadVenta u1 = abm2.traer(1L);
		p1.setUnidadVenta(u1);
		
		abm.modificar(p1);
		
		Pedido mod = abm.traer(1L);
		System.out.printf("Pedido Modificado: %s\n", mod);
	}
}
*/