package test.testPersonal;

import datos.Personal;
import datos.Cajero;
import negocio.PersonalABM;

public class TestTraerCajeros {
	public static void main(String[] args) {
		PersonalABM abm = new PersonalABM();
		System.out.println("--- Cajeros ---");
		for (Cajero c : abm.traerCajeros()) {
			System.out.println(c);
		}
	}
}
