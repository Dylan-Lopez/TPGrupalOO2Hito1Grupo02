package test.UnidadVentaTest;

import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class TestActualizarUnidadVenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();
		try {
			UnidadVenta u = abm.traerPorCodigo("FT-001");
			if (u != null) {
				u.setNombreComercial("Food Truck Sabores - Sucursal 2");
				u.setSuperficie(30.0f);
				abm.modificar(u);
				System.out.println(abm.traerPorCodigo("FT-001"));
			} else {
				System.out.println("No se encontro la Unidad de Venta con codigo FT-001");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
