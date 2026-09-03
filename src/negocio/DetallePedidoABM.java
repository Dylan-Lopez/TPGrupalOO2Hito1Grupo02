package negocio;

import java.util.List;

import dao.DetallePedidoDao;
import datos.DetallePedido;
import datos.Plato;
import datos.Pedido;

public class DetallePedidoABM {

	DetallePedidoDao dao = new DetallePedidoDao();

	public int agregar(Plato plato, int cantidad, Pedido pedido) throws Exception {
		
		if (pedido == null) {
			throw new Exception("El pedido no puede ser null");
		}

		DetallePedido detalle = new DetallePedido(plato, cantidad, pedido);

		
		return dao.agregar(detalle);
	}

	public void modificar(DetallePedido detalle) throws Exception {

		DetallePedido detalleExistente =
				dao.traer(detalle.getIdDetalle());
		
		if (detalleExistente == null) {
			throw new Exception("No existe el detalle que se desea modificar");
		}
		
		dao.actualizar(detalle);
		
		
	}

	public void eliminar(long idDetalle) throws Exception {
		
		DetallePedido detalle = dao.traer(idDetalle);

		if (detalle == null) {
			throw new Exception("No existe el detalle que se desea eliminar");
		}

		dao.eliminar(detalle);
	}
	
	public DetallePedido traer(long idDetalle) throws Exception {
		
		DetallePedido detalle = dao.traer(idDetalle);
		
		if (detalle == null) {
			throw new Exception("No existe un detalle con id " + idDetalle);
		}	
		return detalle;	
	}

	public List<DetallePedido> traer(Pedido pedido) throws Exception {

		if (pedido == null) {
			throw new Exception("El pedido no puede ser null");
		}

		List<DetallePedido> detalles = dao.traer(pedido);
		
		if (detalles == null || detalles.isEmpty()) {
			throw new Exception("El pedido " + pedido.getIdPedido() + " no posee detalles");
		}
		
		return detalles;
	}
	
	public List<DetallePedido> traerPorPlato(long idPlato) throws Exception {

		List<DetallePedido> detalles = dao.traerPorPlato(idPlato);

		if (detalles == null || detalles.isEmpty()) {
			throw new Exception("No existen detalles de pedidos para el plato " + idPlato);
		}

		return detalles;
	}

}