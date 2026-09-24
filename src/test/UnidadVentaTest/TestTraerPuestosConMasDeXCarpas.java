package test.UnidadVentaTest;

import java.util.List;

import datos.PuestoDesarmable;
import negocio.UnidadVentaABM;

public class TestTraerPuestosConMasDeXCarpas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();

		// En 3 carpas para probar funcionalidad
		int cantidadMinima = 3;

		// Festival por el que filtrar. Dejar en -1 para traer TODOS (sin filtrar por festival)
		int idFestival = -1;

		List<PuestoDesarmable> lista = abm.traerPuestosConMasDeXCarpas(cantidadMinima, idFestival);

		// Texto del titulo segun si se filtro o no
		String detalleFestival;
		if (idFestival == -1) {
			detalleFestival = "(todos los festivales)";
		} else {
			detalleFestival = "(festival " + idFestival + ")";
		}

		if (lista.isEmpty()) {
			System.out.println("No hay puestos con mas de " + cantidadMinima + " carpas " + detalleFestival + ".");
		} else {
			System.out.println("\n--- Puestos Desarmables con mas de " + cantidadMinima + " carpas " + detalleFestival + " ---");
			for (PuestoDesarmable p : lista) {
				System.out.println(p.getNombreComercial() + " -> " + p);
			}
		}
	}
}
