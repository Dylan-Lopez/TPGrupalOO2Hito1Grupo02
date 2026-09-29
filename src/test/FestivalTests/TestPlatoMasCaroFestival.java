package test.FestivalTests;

import datos.Festival;
import datos.Plato;
import negocio.FestivalABM;

public class TestPlatoMasCaroFestival {
    public static void main(String[] args) {
        FestivalABM abm = new FestivalABM();
        Festival f = abm.traer(1);
        Plato p = abm.traerPlatoMasCaroDeFestival(f);
        System.out.println(p);
    }

}
