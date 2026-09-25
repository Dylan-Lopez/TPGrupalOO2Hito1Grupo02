package test.FestivalTests;

import datos.Festival;
import negocio.FestivalABM;

public class TestUnidadesVentaFestival {
    public static void main(String[] args) {
        FestivalABM abm = new FestivalABM();
        Festival f = abm.traerFestivalYUnidades(1);
        System.out.println(f.getUnidadesVenta());
    }
}