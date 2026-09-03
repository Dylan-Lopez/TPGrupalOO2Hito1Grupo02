package datos;

public class DetallePedido {

	private long idDetalle;
	private Plato plato;
	private int cantidad;
	private Pedido pedido;

	public DetallePedido() {
	}

	public DetallePedido(Plato plato, int cantidad, Pedido pedido) throws Exception {
		this.setPlato(plato);
		this.setCantidad(cantidad);
		this.setPedido(pedido);
	}

	public long getIdDetalle() {
		return idDetalle;
	}

	protected void setIdDetalle(long idDetalle) {
		this.idDetalle = idDetalle;
	}

	public Plato getPlato() {
		return plato;
	}

	public void setPlato(Plato plato) throws Exception {
		if (plato == null) {
			throw new Exception("Error: El plato no puede ser null");
		}

		this.plato = plato;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) throws Exception {
		if (cantidad <= 0) {
			throw new Exception("Error: La cantidad debe ser mayor a cero");
		}

		this.cantidad = cantidad;
	}
	

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) throws Exception {
		if (pedido == null) {
			throw new Exception("Error: El pedido no vinculado no puede ser null.");
		}
		this.pedido = pedido;
	}
	
	@Override
	public String toString() {
		return "DetallePedido [idDetalle=" + idDetalle
				+ ", plato=" + plato
				+ ", cantidad=" + cantidad + "]";
	}
}
