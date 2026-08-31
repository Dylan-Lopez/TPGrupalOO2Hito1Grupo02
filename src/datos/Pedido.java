package datos;

import java.time.LocalDate;
import java.util.Set;

public class Pedido {

	private long idPedido;
	private LocalDate fechaTransaccion;
	private UnidadVenta unidadVenta;
	private Set<DetallePedido> lstDetalles;

	public Pedido() {
	}

	public Pedido(LocalDate fechaTransaccion,
			UnidadVenta unidadVenta) throws Exception {

		super();
		this.setFechaTransaccion(fechaTransaccion);
		this.setUnidadVenta((unidadVenta));
		
	}
	
	
	public long getIdPedido() {
		return idPedido;
	}

	protected void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(LocalDate fechaTransaccion) throws Exception {

	    if (fechaTransaccion == null) {
	        throw new Exception("La fecha de transacción es obligatoria");
	    }

	    this.fechaTransaccion = fechaTransaccion;
	}
	
	public UnidadVenta getUnidadVenta() {
		return unidadVenta;
	}

	public void setUnidadVenta(UnidadVenta unidadVenta) throws Exception {

	    if (unidadVenta == null) {
	        throw new Exception("La unidad de venta no puede ser null");
	    }

	    this.unidadVenta = unidadVenta;
	}

	public Set<DetallePedido> getLstDetalles() {
		return lstDetalles;
	}

	public void setLstDetalles(Set<DetallePedido> lstDetalles) {
		this.lstDetalles = lstDetalles;
	}
	
	public void agregar(DetallePedido detalle) {
		lstDetalles.add(detalle);
	}
	
	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido
				+ ", fechaTransaccion=" + fechaTransaccion + "]";
	}
}
