package test.PlatoTests;

import negocio.PlatoABM;

public class TestAgregarPlato {

    public static void main(String[] args) {
        PlatoABM abm = new PlatoABM();
        int idPlato = abm.agregar("Milanesa con papas", 8500.00f, 3200.00f);
        System.out.printf("Id plato insertado: %d\n", idPlato);
    }
	
}
