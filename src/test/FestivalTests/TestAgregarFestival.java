package test.FestivalTests;

import java.time.LocalDate;
import datos.Costo;
import negocio.CostoABM;
import negocio.FestivalABM;

public class TestAgregarFestival {

	public static void main(String[] args) {
        CostoABM costoAbm = new CostoABM();
        Costo costo = costoAbm.traer(2); // 

        FestivalABM festivalAbm = new FestivalABM();
        int idFestival = festivalAbm.agregar("Festival de Verano", "Verano",
                LocalDate.of(2026, 12, 1), LocalDate.of(2027, 2, 28), costo);
        System.out.printf("Id festival insertado: %d\n", idFestival);
    }
	
	
	
}
