package datos;

public class DetallePedido {

	private long idDetalle;
	private Plato plato;
	private int cantidad;

	public DetallePedido() {
	}

	public DetallePedido(Plato plato, int cantidad) throws Exception {
		this.setPlato(plato);
		this.setCantidad(cantidad);
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
			throw new Exception("El plato no puede ser null");
		}

		this.plato = plato;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) throws Exception {
		if (cantidad <= 0) {
			throw new Exception("La cantidad debe ser mayor a cero");
		}

		this.cantidad = cantidad;
	}
	
	@Override
	public String toString() {
		return "DetallePedido [idDetalle=" + idDetalle
				+ ", plato=" + plato
				+ ", cantidad=" + cantidad + "]";
	}
}
