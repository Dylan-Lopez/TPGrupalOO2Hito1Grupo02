package test.PlatoTests;

import datos.Plato;
import negocio.PlatoABM;

public class TestTraerPlato {

	
    public static void main(String[] args) {
        PlatoABM abm = new PlatoABM();
        Plato p = abm.traer(2);
        System.out.println(p);
    }
	
	
	
}
