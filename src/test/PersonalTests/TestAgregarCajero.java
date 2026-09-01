package test.PersonalTests;

import java.time.LocalDate;
import negocio.PersonalABM;

public class TestAgregarCajero {
	public static void main(String[] args) {
		PersonalABM abm = new PersonalABM();
		try {
			long id = abm.agregarCajero("Carlos", "Gomez", 30123458L, LocalDate.of(1985, 5, 10),
					LocalDate.of(2010, 3, 1), 450000.0, "mañana");
			System.out.printf("Cajero agregado con ID: %d\n", id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
