package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestActualizarCliente {
	public static void main(String[] args) {

		ClienteABM abm = new ClienteABM();
		
		// traer el obj a modificar
		// Nota: Se usa 'L' al final del número para especificar que es de tipo long
		// Nota: el id depende del ultimo objeto agregado
		Cliente cliente = abm.traer(3L);
		System.out.printf("Cliente a Modificar: %s\n\n", cliente);

		// modificar por set los atributos
		cliente.setDni(35000003);

		// update del objeto
		abm.modificar(cliente);

		// En este caso se usa el traer por int
		// ya que al no aclarar el tipo (como en el traer anterior) se asume que es int
		Cliente clienteMod = abm.traer(35000003);
		System.out.printf("Cliente Modificado: %s\n", clienteMod);

	}
}
