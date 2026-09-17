package test.UnidadVentaTest;

import java.util.List;

import datos.PuestoDesarmable;
import negocio.UnidadVentaABM;

public class TestTraerPuestosConMasDeXCarpas {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();

		//En 3 carpas para probar funcionalidad
		int cantidadMinima = 3;

		List<PuestoDesarmable> lista = abm.traerPuestosConMasDeXCarpas(cantidadMinima);

		if (lista.isEmpty()) {
			System.out.println("No hay puestos con mas de " + cantidadMinima + " carpas.");
		} else {
			System.out.println("\n--- Puestos Desarmables con mas de " + cantidadMinima + " carpas ---");
			for (PuestoDesarmable p : lista) {
				System.out.println(p);
			}
		}
	}

}
