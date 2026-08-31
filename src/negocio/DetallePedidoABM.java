package negocio;

import java.util.List;

import dao.DetallePedidoDao;
import datos.DetallePedido;
import datos.Plato;

public class DetallePedidoABM {

	DetallePedidoDao dao = new DetallePedidoDao();

	public DetallePedido traer(long idDetalle) {
		return dao.traer(idDetalle);
	}

	public List<DetallePedido> traer() {
		return dao.traer();
	}

	public int agregar(Plato plato, int cantidad) throws Exception {

		DetallePedido detalle = new DetallePedido(plato, cantidad);

		return dao.agregar(detalle);
	}

	public void modificar(DetallePedido detalle) {
		dao.actualizar(detalle);
	}

	public void eliminar(long idDetalle) {
		DetallePedido detalle = dao.traer(idDetalle);
		dao.eliminar(detalle);
	}
}
