package test.UnidadVentaTest;

import java.util.List;

import datos.FoodTruck;
import datos.Festival;
import negocio.UnidadVentaABM;
import negocio.FestivalABM;

public class TestTraerFoodTruckFiltrosConexionYSuperficie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		UnidadVentaABM abm = new UnidadVentaABM();
		FestivalABM festivalABM = new FestivalABM();

		float superficieMinima = 25;

		// Por defecto trae TODOS (sin filtrar por festival)
		Festival festival = null;

		// Para filtrar por un festival, descomentar y poner el id (1, 2, 3...):
		festival = festivalABM.traer(1);

		List<FoodTruck> lista = abm.traerFoodTrucksFiltrosConConexionYSuperficie(superficieMinima, festival);

		// Texto del titulo segun si se filtro o no
		String detalleFestival;
		if (festival == null) {
			detalleFestival = "(todos los festivales)";
		} else {
			detalleFestival = "(festival: " + festival.getNombre() + ")";
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
