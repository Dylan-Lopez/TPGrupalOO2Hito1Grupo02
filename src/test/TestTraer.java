package test;

import negocio.ClienteABM;
import datos.Cliente;

public class TestTraer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ClienteABM abm = new ClienteABM();
		
		for(Cliente c: abm.traer()) System.out.println(c);
	
	}

}