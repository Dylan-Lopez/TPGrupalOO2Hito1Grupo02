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

		// Festival por el que filtrar. Dejar en -1 para traer TODOS (sin filtrar por festival)
		int idFestival = -1;

		List<PuestoDesarmable> lista = abm.traerPuestosCarpasYMontaje(cantidadMinima, tiempoMaximo, idFestival);

		// Texto del titulo segun si se filtro o no
		String detalleFestival;
		if (idFestival == -1) {
			detalleFestival = "(todos los festivales)";
		} else {
			detalleFestival = "(festival " + idFestival + ")";
		}

		if (lista.isEmpty()) {
			System.out.println("No hay puestos que cumplan ambas condiciones " + detalleFestival + ".");
		} else {
			System.out.println("\n--- Puestos con mas de " + cantidadMinima + " carpas Y montaje menor a " + tiempoMaximo + " " + detalleFestival + " ---");
			for (PuestoDesarmable p : lista) {
				System.out.println(p.getNombreComercial() + " -> " + p);
			}
		}
	}

}
