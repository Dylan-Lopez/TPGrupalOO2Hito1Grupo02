package test.UnidadVentaTest;

import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class TestTraerUnidadVenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();
		
		for (UnidadVenta u : abm.traer()) {
			System.out.println("\n--- Todas las Unidades de Venta ---");
			System.out.println(u);
		}
	}

}
