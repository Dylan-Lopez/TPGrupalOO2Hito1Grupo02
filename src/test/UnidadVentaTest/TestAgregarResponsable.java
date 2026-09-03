package test.UnidadVentaTest;

import datos.Personal;
import datos.UnidadVenta;
import negocio.PersonalABM;
import negocio.UnidadVentaABM;

public class TestAgregarResponsable {

	public static void main(String[] args) {

		UnidadVentaABM unidadABM = new UnidadVentaABM();
		PersonalABM personalABM = new PersonalABM();

		try {

			UnidadVenta unidad = unidadABM.traer(1);
			Personal responsable = personalABM.traer(1L);

			unidad.setResponsable(responsable);

			unidadABM.modificar(unidad);

			System.out.println("Responsable agregado correctamente.");

		} catch (Exception e) {

			System.out.println("Error: " + e.getMessage());
		}
	}
}
