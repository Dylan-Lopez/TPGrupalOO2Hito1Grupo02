package test.testPersonal;

import java.time.LocalDate;
import negocio.PersonalABM;

public class TestAgregarCocinero {
	public static void main(String[] args) {
		PersonalABM abm = new PersonalABM();
		try {
			long id = abm.agregarCocinero("Marta", "Rodriguez", 32987655L, LocalDate.of(1988, 8, 20),
					LocalDate.of(2012, 6, 15), 600000.0, "Comida Italiana", 15000.0f);
			System.out.printf("Cocinero agregado con ID: %d\n", id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
