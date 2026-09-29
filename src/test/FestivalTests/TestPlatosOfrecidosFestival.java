package test.FestivalTests;

import java.util.List;

import datos.Festival;
import datos.Plato;
import negocio.FestivalABM;

public class TestPlatosOfrecidosFestival {
	
    public static void main(String[] args) {
        FestivalABM abm = new FestivalABM();
        Festival f = abm.traer(1);
        List<Plato> platos = abm.traerPlatosPorFestival(f);
        for (Plato p : platos) {
            System.out.println(p);
        }
    }

}
