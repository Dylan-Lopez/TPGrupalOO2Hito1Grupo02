package test.PersonalTests;

import datos.Personal;
import negocio.PersonalABM;

public class TestEliminarCajero {
	public static void main(String[] args) {
		PersonalABM abm = new PersonalABM();
		try {
			Personal p = abm.traerPorDni(30123456L);
			if (p != null) {
				abm.eliminar(p.getIdPersonal());
				System.out.printf("Cajero con DNI 30123456 eliminado con éxito\n");
			} else {
				System.out.println("No se encontró el Cajero con DNI 30123456");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
