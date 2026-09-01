package test.testPersonal;

import datos.Personal;
import negocio.PersonalABM;

public class TestEliminarCocinero {
	public static void main(String[] args) {
		PersonalABM abm = new PersonalABM();
		try {
			Personal p = abm.traerPorDni(32987656L);
			if (p != null) {
				abm.eliminar(p.getIdPersonal());
				System.out.printf("Cocinero con DNI 32987656 eliminado con éxito\n");
			} else {
				System.out.println("No se encontró el Cocinero con DNI 32987656");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
