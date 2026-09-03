package test.UnidadVentaTest;

import datos.Festival;
import datos.UnidadVenta;
import negocio.FestivalABM;
import negocio.UnidadVentaABM;

public class TestAgregarFestivalAUnidad {

	public static void main(String[] args) {

		try {

			UnidadVentaABM unidadABM = new UnidadVentaABM();
			FestivalABM festivalABM = new FestivalABM();

			// Traer la unidad y el festival existentes
			UnidadVenta unidad = unidadABM.traer(1);
			Festival festival = festivalABM.traer(1);

			// Agregar el festival a la unidad
			unidad.agregar(festival);

			// Guardar la modificación
			unidadABM.modificar(unidad);

			System.out.println("Festival agregado correctamente a la unidad de venta.");

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
