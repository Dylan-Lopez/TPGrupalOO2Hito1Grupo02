package test.UnidadVentaTest;

import java.util.List;

import datos.FoodTruck;
import negocio.UnidadVentaABM;

public class TestTraerFoodTruckFiltrosConexionYSuperficie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UnidadVentaABM abm = new UnidadVentaABM();

		float superficieMinima = 25;

		List<FoodTruck> lista = abm.traerFoodTrucksFiltrosConConexionYSuperficie(superficieMinima);

		if (lista.isEmpty()) {
			System.out.println("No hay FoodTrucks que cumplan ambas condiciones.");
		} else {
			System.out.println("\n--- FoodTrucks con superficie mayor a " + superficieMinima + " Y con conexion electrica ---");
			for (FoodTruck f : lista) {
				System.out.println(f);
			}
		}

	}

}
