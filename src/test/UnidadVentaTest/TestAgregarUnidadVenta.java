package test.UnidadVentaTest;

import negocio.UnidadVentaABM;

public class TestAgregarUnidadVenta {
	public static void main(String[] args) {
		UnidadVentaABM abm = new UnidadVentaABM();
		try {
			int id = abm.agregarFoodTruck("Food Truck Sabores", 25.5f, "FT-001", null, "AB123CD", true);
			System.out.printf("FoodTruck agregada con ID: %d\n", id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
