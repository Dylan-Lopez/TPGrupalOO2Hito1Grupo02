package negocio;

import java.time.LocalDate;
import java.util.List;
import dao.PedidoDao;
import datos.Pedido;
import datos.UnidadVenta;

public class PedidoABM {

	PedidoDao dao = new PedidoDao();

	public Pedido traer(long idPedido) {
		return dao.traer(idPedido);
	}

	public int agregar(LocalDate fechaTransaccion, long idUnidad) throws Exception {

		UnidadVentaABM unidadABM = new UnidadVentaABM();

		UnidadVenta unidad = unidadABM.traer(idUnidad);

		Pedido p = new Pedido(fechaTransaccion, unidad);

		return dao.agregar(p);
	}

	public void modificar(Pedido p) {
		dao.actualizar(p);
	}

	public void eliminar(long idPedido) {
		Pedido p = dao.traer(idPedido);
		dao.eliminar(p);
	}

	public List<Pedido> traer() {
		return dao.traer();
	}

	public Pedido traerPedidoYDetalles(long idPedido) {
		return dao.traerPedidoYDetalles(idPedido);
	}

	public List<Pedido> traerPedidosPorUnidad(long idUnidad) throws Exception {

		List<Pedido> pedidos = dao.traerPedidosPorUnidad(idUnidad);

		if (pedidos == null || pedidos.isEmpty()) {
			throw new Exception("No existen pedidos para la unidad " + idUnidad);
		}

		return pedidos;
	}

	public List<Pedido> traerPedidosPorUnidadEntreFechas(long idUnidad, LocalDate fechaDesde, LocalDate fechaHasta)
			throws Exception {

		if (fechaDesde == null || fechaHasta == null) {
			throw new Exception("Las fechas no pueden ser null");
		}

		if (fechaDesde.isAfter(fechaHasta)) {
			throw new Exception("La fecha desde no puede ser posterior a la fecha hasta");
		}

		List<Pedido> pedidos = dao.traerPedidosPorUnidadEntreFechas(idUnidad, fechaDesde, fechaHasta);

		if (pedidos == null || pedidos.isEmpty()) {
			throw new Exception(
					"No existen pedidos para la unidad " + idUnidad + " entre " + fechaDesde + " y " + fechaHasta);
		}

		return pedidos;
	}
}
