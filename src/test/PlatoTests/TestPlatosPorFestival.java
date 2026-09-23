package test.PlatoTests;

import java.util.List;

import datos.Plato;
import negocio.PlatoABM;

public class TestPlatosPorFestival {
	
    public static void main(String[] args) {
        PlatoABM abm = new PlatoABM();
        List<Plato> platos = abm.traerPlatosPorFestival(1);
        for (Plato p : platos) {
            System.out.println(p);
        }
    }

}
