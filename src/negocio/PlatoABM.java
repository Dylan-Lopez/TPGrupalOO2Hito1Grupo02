package negocio;

import java.util.List;

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
    
    public List<Plato> traerPorPrecioMayorA(float precio) {
        return dao.traerPorPrecioMayorA(precio);
    }
    
    public List<Plato> traerPlatosPorFestival(int idFestival) {
        return dao.traerPlatosPorFestival(idFestival);
    }
    
    public Plato traerPlatoMasCaroDeFestvial(int idFestival) {
        return dao.traerPlatoMasCaroDeFestival(idFestival);
    }

}
