package test.FestivalTests;

import java.time.LocalDate;
import java.util.List;

import datos.Festival;
import negocio.FestivalABM;

public class TestTraerFestivalEntreFechas {
	
    public static void main(String[] args) {
        FestivalABM abm = new FestivalABM();
        List<Festival> lista = abm.traerEntreFechas(LocalDate.of(2026, 12, 1), LocalDate.of(2026, 12, 31));
        for (Festival f : lista) {
            System.out.println(f);
        }
    }

}
