package test.testPersonal;

import java.time.LocalDate;
import datos.Personal;
import negocio.PersonalABM;

public class TestTraerPersonalEntreFechas {
	public static void main(String[] args) {
		PersonalABM abm = new PersonalABM();
		LocalDate desde = LocalDate.of(1988, 1, 1);
		LocalDate hasta = LocalDate.of(1989, 12, 31);

		System.out.println("--- Personal nacido entre " + desde + " y " + hasta + " ---");
		for (Personal p : abm.traer(desde, hasta)) {
			System.out.println(p);
		}
	}
}
