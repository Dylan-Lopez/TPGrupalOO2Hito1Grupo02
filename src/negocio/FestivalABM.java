package negocio;

import java.time.LocalDate;
import dao.FestivalDao;
import datos.Costo;
import datos.Festival;

public class FestivalABM {
	
	private FestivalDao dao = new FestivalDao();

    public int agregar(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin, Costo costo) {
        Festival f = new Festival(nombre, temporada, fechaInicio, fechaFin, costo);
        return dao.agregar(f);
    }

    public Festival traer(int idFestival) {
        return dao.traer(idFestival);
    }

}
