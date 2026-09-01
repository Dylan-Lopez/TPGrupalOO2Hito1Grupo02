package test.PersonalTests;

import java.time.LocalDate;
import datos.Cajero;
import datos.Personal;

public class TestCalcularAntiguedad {
	public static void main(String[] args) {
		try {
			LocalDate ingreso = LocalDate.now().minusYears(5);
			Personal p = new Cajero("Juan", "Perez", 35000111, LocalDate.of(1995, 5, 5), ingreso, 450000.0, "noche");
			System.out.println("Antigüedad calculada (Esperado 5 años): " + p.calcularAntiguedad() + " años");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
