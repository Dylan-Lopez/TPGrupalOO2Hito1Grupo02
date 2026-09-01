package test;

import java.time.LocalDate;
import negocio.ClienteABM;

public class TestAgregarCliente {
	public static void main(String[] args) {

		ClienteABM abm = new ClienteABM();
		
		try {
			long ultimoIdCliente;
			ultimoIdCliente = abm.agregar("Apellido", "Nombre", 35000000, LocalDate.now());
			System.out.printf("Id cliente: %d", ultimoIdCliente);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}
		
		/*
		En el formateo de Strings con printf tiene varios especificadores de formato.
		Algunos de los más comunes son:
			%d: Entero con signo (para int y long).
			%f: Número de punto flotante (para float y double).
			%s: Cadena de caracteres.
			%c: Carácter.
			%b: Valor booleano.
		*/
	}
}
