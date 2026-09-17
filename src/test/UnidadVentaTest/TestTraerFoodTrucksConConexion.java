package test.UnidadVentaTest;

import java.util.List;

import datos.FoodTruck;
import negocio.UnidadVentaABM;

public class TestTraerFoodTrucksConConexion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();

		//Trae solo los FoodTruck con conexion electrica 
		List<FoodTruck> lista = abm.traerFoodTrucksConConexion();

		if (lista.isEmpty()) {
			System.out.println("No hay FoodTrucks con conexion electrica.");
		} else {
			for (FoodTruck f : lista) {
				System.out.println("\n--- FoodTrucks con conexion electrica ---");
				System.out.println(f);
			}
		}
	}

}
