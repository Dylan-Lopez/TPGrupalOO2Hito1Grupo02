package test.testPersonal;

import datos.Personal;
import negocio.PersonalABM;

public class TestTraerPersonal {
	public static void main(String[] args) {
		PersonalABM abm = new PersonalABM();
		System.out.println("--- Todo el Personal ---");
		for (Personal p : abm.traer()) {
			System.out.println(p);
		}
	}
}
