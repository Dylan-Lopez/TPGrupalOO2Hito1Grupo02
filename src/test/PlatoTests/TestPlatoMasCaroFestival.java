package test.PlatoTests;

import datos.Plato;
import negocio.PlatoABM;

public class TestPlatoMasCaroFestival {

    public static void main(String[] args) {
        PlatoABM abm = new PlatoABM();
        Plato p = abm.traerPlatoMasCaroDeFestvial(1);
        System.out.println(p);
    }
	
	
}
