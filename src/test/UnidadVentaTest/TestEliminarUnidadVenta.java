package test.UnidadVentaTest;

import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class TestEliminarUnidadVenta {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();
		try {
			UnidadVenta u = abm.traerPorCodigo("FT-001");
			if (u != null) {
				abm.eliminar(u.getIdUnidadVenta());
				System.out.printf("Unidad de Venta con codigo FT-001 eliminada con exito\n");
			} else {
				System.out.println("No se encontro la Unidad de Venta con codigo FT-001");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
