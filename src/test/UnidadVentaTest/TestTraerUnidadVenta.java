package test.UnidadVentaTest;

import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class TestTraerUnidadVenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();
		System.out.println("--- Todas las Unidades de Venta ---");
		for (UnidadVenta u : abm.traer()) {
			System.out.println(u);
		}
	}

}
