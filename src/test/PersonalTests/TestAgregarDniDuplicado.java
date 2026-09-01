package test.PersonalTests;

import java.time.LocalDate;
import negocio.PersonalABM;

public class TestAgregarDniDuplicado {
	public static void main(String[] args) {
		
		//cajero
		PersonalABM abm = new PersonalABM();
		try {
			abm.agregarCajero("Pedro", "Alvarez", 30123456, LocalDate.of(1992, 4, 4), LocalDate.now(), 480000, "noche");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		// cocinero
		PersonalABM abm2 = new PersonalABM();
		try {
			abm2.agregarCocinero("Marta", "Rodriguez", 32987656L, LocalDate.of(1988, 8, 20),
					LocalDate.of(2012, 6, 15), 600000.0, "Comida Italiana", 15000.0f);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
