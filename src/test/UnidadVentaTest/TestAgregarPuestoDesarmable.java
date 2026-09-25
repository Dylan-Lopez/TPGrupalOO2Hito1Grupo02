package test.UnidadVentaTest;

import negocio.UnidadVentaABM;

public class TestAgregarPuestoDesarmable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UnidadVentaABM abm = new UnidadVentaABM();
		try {
			//Tiempo en minutos
			int id = abm.agregarPuestoDesarmable("Puesto Desarmable Pepitos", 36, "PD-001", null, 5, 24);
			System.out.printf("Puesto Desarmable agregado con ID: %d\n", id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
