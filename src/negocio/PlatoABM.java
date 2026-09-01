package negocio;

import dao.PlatoDao;
import datos.Plato;

public class PlatoABM {
	
    private PlatoDao dao = new PlatoDao();

    public int agregar(String nombre, float precio, float costoDeProduccion) {
        Plato p = new Plato(nombre, precio, costoDeProduccion);
        return dao.agregar(p);
    }

    public Plato traer(int idPlato) {
        return dao.traer(idPlato);
    }

}
