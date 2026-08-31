package negocio;

import dao.CostoDao;
import datos.Costo;

public class CostoABM {

	private CostoDao dao = new CostoDao();
	
	public Costo traer (int idCosto)
	{
		return dao.traerCosto(idCosto);
	}
	
	
}
