package test.UnidadVentaTest;

import datos.Personal;
import datos.UnidadVenta;
import negocio.PersonalABM;
import negocio.UnidadVentaABM;

public class TestAgregarStaff {

	public static void main(String[] args) {

		UnidadVentaABM unidadABM = new UnidadVentaABM();
		PersonalABM personalABM = new PersonalABM();

		try {

			UnidadVenta unidad =
					unidadABM.traerUnidadYStaff(1);

			Personal personal =
					personalABM.traer(2L);

			if (unidad == null) {
				throw new Exception("No existe la unidad.");
			}

			if (personal == null) {
				throw new Exception("No existe el personal.");
			}

			unidad.getLstStaff().add(personal);

			unidadABM.modificar(unidad);

			System.out.println(
					"Personal agregado al staff correctamente."
			);

			for (Personal integrante : unidad.getLstStaff()) {
				System.out.println(integrante);
			}

		} catch (Exception e) {

			System.out.println("Error: " + e.getMessage());
		}
	}
}
