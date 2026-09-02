package negocio;

import java.time.LocalDate;
import java.util.List;
import dao.PedidoDao;
import datos.Pedido;
import datos.UnidadVenta;
import datos.DetallePedido;

public class PedidoABM {

	PedidoDao dao = new PedidoDao();

	public Pedido traer(long idPedido) throws Exception {

		if (idPedido <= 0) {
			throw new Exception("El id del pedido debe ser mayor a cero");
		}

		Pedido pedido = dao.traer(idPedido);

		if (pedido == null) {
			throw new Exception("No existe un pedido con id " + idPedido);
		}

		return pedido;
	}

	public int agregar(LocalDate fechaTransaccion, long idUnidad) throws Exception {

		
		UnidadVentaABM unidadABM = new UnidadVentaABM();

		UnidadVenta unidad = unidadABM.traer(idUnidad);
		
		if (unidad == null) {
			throw new Exception("No existe una unidad de venta con id " + idUnidad);
		}
		
		Pedido p = new Pedido(fechaTransaccion, unidad);

		return dao.agregar(p);
	}

	public void modificar(Pedido pedido) throws Exception {
		
		Pedido pedidoExistente = dao.traer(pedido.getIdPedido());

		if (pedidoExistente == null) {
			throw new Exception("No existe el pedido que se desea modificar");
		}
		
		dao.actualizar(pedido);
	}

	public void eliminar(long idPedido) throws Exception {
		
		Pedido pedido = dao.traer(idPedido);
		
		if (pedido == null) {
			throw new Exception("No existe el pedido que se desea eliminar");
		}

		DetallePedidoABM detalleABM = new DetallePedidoABM();

		List<DetallePedido> detalles = detalleABM.traer(pedido);

		for (DetallePedido detalle : detalles) {
			detalleABM.eliminar(detalle.getIdDetalle());
		}

		dao.eliminar(pedido);
	}

	public List<Pedido> traer() {
		return dao.traer();
	
	}

	public Pedido traerPedidoYDetalles(long idPedido) throws Exception {
		
		Pedido pedido = dao.traerPedidoYDetalles(idPedido);

		if (pedido == null) {
			throw new Exception("No existe un pedido con id " + idPedido);
		}
		
		return pedido;

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
