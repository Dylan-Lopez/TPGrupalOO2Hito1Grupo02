package negocio;

import java.util.List;

import dao.UnidadVentaDao;
import datos.FoodTruck;
import datos.Personal;
import datos.PuestoDesarmable;
import datos.UnidadVenta;

public class UnidadVentaABM {

	private UnidadVentaDao dao = UnidadVentaDao.getInstancia();

	public int agregarFoodTruck(String nombreComercial, float superficie, String codigo, Personal responsable,
			String patente, boolean conexionElectrica) throws Exception {
		if (traerPorCodigo(codigo) != null) {
			throw new Exception("ERROR ya existe una Unidad de Venta con codigo: " + codigo);
		}
		FoodTruck f = new FoodTruck(nombreComercial, superficie, codigo, responsable, patente, conexionElectrica);
		return dao.agregar(f);
	}

	public int agregarPuestoDesarmable(String nombreComercial, float superficie, String codigo, Personal responsable,
			int cantidadCarpas, float tiempoMontaje) throws Exception {
		if (traerPorCodigo(codigo) != null) {
			throw new Exception("ERROR ya existe una Unidad de Venta con codigo: " + codigo);
		}
		PuestoDesarmable p = new PuestoDesarmable(nombreComercial, superficie, codigo, responsable, cantidadCarpas,
				tiempoMontaje);
		return dao.agregar(p);
	}

	public void modificar(UnidadVenta u) {
		dao.actualizar(u);
	}

	public void eliminar(int idUnidadVenta) throws Exception {

		UnidadVenta u = dao.traer(idUnidadVenta);

		if (u == null) {
			throw new Exception(
				"ERROR no existe Unidad de Venta con ID: " + idUnidadVenta
			);
		}

		PedidoABM pedidoABM = new PedidoABM();

		List<Pedido> pedidos =
				pedidoABM.traerPedidosPorUnidad(idUnidadVenta);

		//nuevo
		if (pedidos != null && !pedidos.isEmpty()) {
			throw new Exception(
				"No se puede eliminar la unidad porque tiene pedidos asociados"
			);
		}

		dao.eliminar(u);
	}

	public UnidadVenta traer(int idUnidadVenta) {
		return dao.traer(idUnidadVenta);
	}

	public List<UnidadVenta> traer() {
		return dao.traer();
	}

	public List<FoodTruck> traerFoodTrucks() {
		return dao.traerFoodTrucks();
	}

	public List<PuestoDesarmable> traerPuestosDesarmables() {
		return dao.traerPuestosDesarmables();
	}

	public UnidadVenta traerPorCodigo(String codigo) {
		return dao.traerPorCodigo(codigo);
	}

	//Nuevo
	public UnidadVenta traerUnidadYStaff(int idUnidadVenta) {
		return dao.traerUnidadYStaff(idUnidadVenta);
	}
}
