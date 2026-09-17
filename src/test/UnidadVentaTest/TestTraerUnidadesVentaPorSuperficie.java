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

		List<UnidadVenta> lista = abm.traerPorSuperficieMayorA(superficieMinima);

		if (lista.isEmpty()) {
			System.out.println("No hay unidades que superen esa superficie.");
		} else {
			System.out.println("\n--- Unidades de Venta con superficie mayor a " + superficieMinima + " ---");
			for (UnidadVenta u : lista) {
				System.out.println(u);
			}
		}
	}

}
