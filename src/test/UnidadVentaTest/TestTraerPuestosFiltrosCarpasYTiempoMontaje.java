package test.UnidadVentaTest;

import java.util.List;

import datos.PuestoDesarmable;
import negocio.UnidadVentaABM;

public class TestTraerPuestosFiltrosCarpasYTiempoMontaje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();
		
		// Cant min carpas 3 - TiempoMax 30
		int cantidadMinima = 3;
		float tiempoMaximo = 30;

		List<PuestoDesarmable> lista = abm.traerPuestosCarpasYMontaje(cantidadMinima, tiempoMaximo);

		if (lista.isEmpty()) {
			System.out.println("No hay puestos que cumplan ambas condiciones.");
		} else {
			for (PuestoDesarmable p : lista) {
				System.out.println("\n--- Puestos con mas de " + cantidadMinima + " carpas Y montaje menor a " + tiempoMaximo + " ---");
				System.out.println(p);
			}
		}
	}

}
