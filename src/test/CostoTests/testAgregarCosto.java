package test.CostoTests;

import negocio.CostoABM;

public class testAgregarCosto {
	
    public static void main(String[] args) {
        CostoABM abm = new CostoABM();
        int idCosto = abm.agregar(2200.00f, 950.50f, 0f);
        System.out.printf("Id costo insertado: %d\n", idCosto);
    }

}
