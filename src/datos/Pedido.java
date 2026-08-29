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

	public Pedido(LocalDate fechaTransaccion, UnidadVenta unidad) {
		super();
		this.fechaTransaccion = fechaTransaccion;
		this.unidadVenta = unidad;
	}

	}

	public long getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(long idPedido) {
		this.idPedido = idPedido;
	}

	public LocalDate getFechaTransaccion() {
		return fechaTransaccion;
	}

	public void setFechaTransaccion(LocalDate fechaTransaccion) {
		this.fechaTransaccion = fechaTransaccion;
	}

	public UnidadVenta getUnidadVenta() {
		return unidadVenta;
	}

	public void setUnidadVenta(UnidadVenta unidadVenta) {
		this.unidadVenta = unidadVenta;
	}

	public Set<DetallePedido> getLstDetalles() {
		return lstDetalles;
	}

	public void setLstDetalles(Set<DetallePedido> lstDetalles) {
		this.lstDetalles = lstDetalles;
	}
	
	@Override
	public String toString() {
		return "Pedido [idPedido=" + idPedido
				+ ", fechaTransaccion=" + fechaTransaccion + "]";
	}

}
