package test.UnidadVentaTest;

import java.util.List;

import datos.PuestoDesarmable;
import datos.Festival;
import negocio.UnidadVentaABM;
import negocio.FestivalABM;

public class TestTraerPuestosFiltrosCarpasYTiempoMontaje {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();
		FestivalABM festivalABM = new FestivalABM();

		// Cant min carpas 3 - TiempoMax 30
		int cantidadMinima = 3;
		float tiempoMaximo = 30;

		// Por defecto trae TODOS (sin filtrar por festival)
		Festival festival = null;

		// Para filtrar por un festival, descomentar y poner el id (1, 2, 3...):
		festival = festivalABM.traer(1);

		List<PuestoDesarmable> lista = abm.traerPuestosCarpasYMontaje(cantidadMinima, tiempoMaximo, festival);

		// Texto del titulo segun si se filtro o no
		String detalleFestival;
		if (festival == null) {
			detalleFestival = "(todos los festivales)";
		} else {
			detalleFestival = "(festival: " + festival.getNombre() + ")";
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
