package test.FestivalTests;

import java.time.LocalDate;
import datos.Costo;
import negocio.CostoABM;
import negocio.FestivalABM;

public class TestAgregarFestival {

	public static void main(String[] args) {
        CostoABM costoAbm = new CostoABM();
        Costo costo = costoAbm.traer(5); // 

        FestivalABM festivalAbm = new FestivalABM();
        int idFestival = festivalAbm.agregar("Festival de Navidad", "Verano",
                LocalDate.of(2026, 12, 22), LocalDate.of(2026, 12, 25), costo);
        System.out.printf("Id festival insertado: %d\n", idFestival);
    }
	
	
	
}
