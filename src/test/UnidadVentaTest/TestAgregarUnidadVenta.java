package test.UnidadVentaTest;

import java.time.LocalDate;

import datos.Personal;
import negocio.PersonalABM;
import negocio.UnidadVentaABM;

public class TestAgregarUnidadVenta {
	public static void main(String[] args) {
		UnidadVentaABM abm = new UnidadVentaABM();
		PersonalABM personalAbm = new PersonalABM();
		try {
			Personal responsable = personalAbm.traerPorDni(30123458L);
			if (responsable == null) {
				long idResponsable = personalAbm.agregarCajero("Juan", "Pepe", 30123458L,
						LocalDate.of(1985, 5, 10), LocalDate.of(2010, 3, 1), 450000.0, "mañana");
				responsable = personalAbm.traer(idResponsable);
			}

			int id = abm.agregarFoodTruck("Food Truck Sabores", 25.5f, "FT-001", responsable,
					"AB123CD", true);
			System.out.printf("FoodTruck agregada con ID: %d\n", id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
