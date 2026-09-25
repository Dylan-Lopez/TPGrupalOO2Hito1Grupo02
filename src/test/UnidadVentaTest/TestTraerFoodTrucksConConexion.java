package test.UnidadVentaTest;

import java.util.List;

import datos.FoodTruck;
import negocio.UnidadVentaABM;
import datos.Festival;
import negocio.FestivalABM;

public class TestTraerFoodTrucksConConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();
		FestivalABM festivalABM = new FestivalABM();

		// Por defecto trae TODOS (sin filtrar por festival)
		Festival festival = null;

		// Para filtrar por un festival, descomentar y poner el id (1, 2, 3...):
		festival = festivalABM.traer(1);

		// Trae solo los FoodTruck con conexion electrica (filtrando por festival si corresponde)
		List<FoodTruck> lista = abm.traerFoodTrucksConConexion(festival);

		// Texto del titulo segun si se filtro o no
		String detalleFestival;
		if (festival == null) {
			detalleFestival = "(todos los festivales)";
		} else {
			detalleFestival = "(festival: " + festival.getNombre() + ")";
		}

		if (lista.isEmpty()) {
			System.out.println("No hay FoodTrucks con conexion electrica " + detalleFestival + ".");
		} else {
			System.out.println("\n--- FoodTrucks con conexion electrica " + detalleFestival + " ---");
			for (FoodTruck f : lista) {
				System.out.println(f.getNombreComercial() + " -> " + f);
			}
		}
	}
}
