package negocio;

import dao.CostoDao;
import datos.Costo;

public class CostoABM {

	private CostoDao dao = new CostoDao();
	
	public Costo traer (int idCosto)
	{
		return dao.traerCosto(idCosto);
	}
	
	public int agregar(float costoSuperficie, float costoMontaje, float plusElectricidad) {
		Costo c = new Costo(costoSuperficie, costoMontaje, plusElectricidad);
		return dao.agregar(c);
	}
}
