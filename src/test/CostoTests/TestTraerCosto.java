package test.CostoTests;

import datos.Costo;
import negocio.CostoABM;

public class TestTraerCosto {

    public static void main(String[] args) {
        CostoABM abm = new CostoABM();
        Costo c = abm.traer(1);
        System.out.println(c);
    }
	
	
}
