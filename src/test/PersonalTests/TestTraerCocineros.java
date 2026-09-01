package test.PersonalTests;

import datos.Personal;
import datos.Cocinero;
import negocio.PersonalABM;

public class TestTraerCocineros {
	public static void main(String[] args) {
		PersonalABM abm = new PersonalABM();
		System.out.println("--- Cocineros ---");
		for (Cocinero c : abm.traerCocineros()) {
			System.out.println(c);
		}
	}
}
