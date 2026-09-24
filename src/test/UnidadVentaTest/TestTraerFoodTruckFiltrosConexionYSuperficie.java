package test.UnidadVentaTest;

import java.util.List;

import datos.FoodTruck;
import negocio.UnidadVentaABM;

public class TestTraerFoodTruckFiltrosConexionYSuperficie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UnidadVentaABM abm = new UnidadVentaABM();

		float superficieMinima = 25;

		// Festival por el que filtrar. Dejar en -1 para traer TODOS (sin filtrar por festival)
		int idFestival = -1;

		List<FoodTruck> lista = abm.traerFoodTrucksFiltrosConConexionYSuperficie(superficieMinima, idFestival);

		// Texto del titulo segun si se filtro o no
		String detalleFestival;
		if (idFestival == -1) {
			detalleFestival = "(todos los festivales)";
		} else {
			detalleFestival = "(festival " + idFestival + ")";
		}

		if (lista.isEmpty()) {
			System.out.println("No hay FoodTrucks que cumplan las condiciones " + detalleFestival + ".");
		} else {
			System.out.println("\n--- FoodTrucks con superficie mayor a " + superficieMinima + " Y con conexion electrica " + detalleFestival + " ---");
			for (FoodTruck f : lista) {
				System.out.println(f.getNombreComercial() + " -> " + f);
			}
		}

	}

}
