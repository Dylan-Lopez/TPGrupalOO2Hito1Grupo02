package test.PersonalTests;

import negocio.PersonalABM;
import datos.Cajero;
import datos.Personal;

public class TestActualizarPersonal {
	public static void main(String[] args) {
		PersonalABM abm = new PersonalABM();
		try {
			Personal p = abm.traerPorDni(30123458);
			if (p != null && p instanceof Cajero) {
				Cajero c = (Cajero) p;
				c.setTurno("noche");
				abm.modificar(c);
				System.out.println(abm.traerPorDni(30123458));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
