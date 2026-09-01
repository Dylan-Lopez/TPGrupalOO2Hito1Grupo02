package test.PersonalTests;

import java.time.LocalDate;
import negocio.PersonalABM;

public class TestValidarMayorDeEdad {
	public static void main(String[] args) {
		PersonalABM abm = new PersonalABM();
		try {
			LocalDate nacimientoMenor = LocalDate.now().minusYears(16);
			abm.agregarCajero("Lucas", "Perez", 45000111, nacimientoMenor, LocalDate.now(), 400000, "mañana");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
