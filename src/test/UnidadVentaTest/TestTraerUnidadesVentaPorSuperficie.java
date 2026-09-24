package test.UnidadVentaTest;

import java.util.List;
import datos.UnidadVenta;
import negocio.UnidadVentaABM;

public class TestTraerUnidadesVentaPorSuperficie {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();
		
		//Superficie a utilizar se puede editar por lo que sea necesario para la consulta
		float superficieMinima = 25;
		
		// Festival por el que filtrar. Dejar en -1 para traer TODAS (sin filtrar por festival)
		int idFestival = -1;

		List<UnidadVenta> lista = abm.traerPorSuperficieMayorA(superficieMinima, idFestival);

		// Texto del titulo segun si se filtro o no
		String detalleFestival;
		if (idFestival == -1) {
			detalleFestival = "(todos los festivales)";
		} else {
			detalleFestival = "(festival " + idFestival + ")";
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
