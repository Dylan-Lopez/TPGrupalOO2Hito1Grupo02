package test.UnidadVentaTest;

import java.util.List;

import datos.PuestoDesarmable;
import datos.Festival;
import negocio.UnidadVentaABM;
import negocio.FestivalABM;

public class TestTraerPuestosConMasDeXCarpas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();
		FestivalABM festivalABM = new FestivalABM();

		// En 3 carpas para probar funcionalidad
		int cantidadMinima = 3;

		// Por defecto trae TODOS (sin filtrar por festival)
		Festival festival = null;

		// Para filtrar por un festival, descomentar y poner el id (1, 2, 3...):
		festival = festivalABM.traer(1);

		List<PuestoDesarmable> lista = abm.traerPuestosConMasDeXCarpas(cantidadMinima, festival);

		// Texto del titulo segun si se filtro o no
		String detalleFestival;
		if (festival == null) {
			detalleFestival = "(todos los festivales)";
		} else {
			detalleFestival = "(festival: " + festival.getNombre() + ")";
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
