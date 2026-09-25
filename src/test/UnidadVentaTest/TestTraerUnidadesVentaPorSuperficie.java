package test.UnidadVentaTest;

import java.util.List;
import datos.UnidadVenta;
import datos.Festival;
import negocio.UnidadVentaABM;
import negocio.FestivalABM;

public class TestTraerUnidadesVentaPorSuperficie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();
		FestivalABM festivalABM = new FestivalABM();

		// Superficie a utilizar se puede editar por lo que sea necesario para la consulta
		float superficieMinima = 25;

		// Festival por el que filtrar. Dejar en null para traer TODAS (sin filtrar por festival)
		Festival festival = null;
		// Para filtrar por un festival concreto, descomentar la siguiente linea:
		festival = festivalABM.traer(1);

		List<UnidadVenta> lista = abm.traerPorSuperficieMayorA(superficieMinima, festival);

		// Texto del titulo segun si se filtro o no
		String detalleFestival;
		if (festival == null) {
			detalleFestival = "(todos los festivales)";
		} else {
			detalleFestival = "(festival: " + festival.getNombre() + ")";
		}

		if (lista.isEmpty()) {
			System.out.println("No hay unidades que cumplan la consulta " + detalleFestival + ".");
		} else {
			System.out.println("\n--- Unidades con superficie >= " + superficieMinima + " " + detalleFestival + " ---");
			for (UnidadVenta u : lista) {
				System.out.println(u.getNombreComercial() + " -> " + u);
			}
		}
	}
}
