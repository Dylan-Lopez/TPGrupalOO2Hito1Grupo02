package test.FestivalTests;

import java.util.List;

import datos.Festival;
import negocio.FestivalABM;

public class TestTraerFestivalesConPlusElectricidad {
	
    public static void main(String[] args) {
        FestivalABM abm = new FestivalABM();
        List<Festival> lista = abm.traerConPlusElectricidad();
        for (Festival f : lista) {
            System.out.println(f);
        }
	
   }
}
