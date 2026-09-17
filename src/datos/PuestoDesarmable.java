package datos;

public class PuestoDesarmable extends UnidadVenta{
	
	private int cantidadCarpas;
	private float tiempoMontaje;
	//tiempo en minutos
	
	public PuestoDesarmable() {
		//vacio
	}
	
	public PuestoDesarmable(String nombreComercial, float superficie, String codigo, Personal responsable, int cantidadCarpas, float tiempoMontaje) {
		super(nombreComercial, superficie, codigo, responsable);
		this.cantidadCarpas = cantidadCarpas;
		this.tiempoMontaje = tiempoMontaje;
	}
	
	@Override
	public String toString() {
		return "PuestoDesarmable [cantidadCarpas=" + cantidadCarpas + ", timepoMontaje=" + tiempoMontaje + "]";
	}
	public int getCantidadCarpas() {
		return cantidadCarpas;
	}
	public void setCantidadCarpas(int cantidadCarpas) {
		this.cantidadCarpas = cantidadCarpas;
	}
	public float getTiempoMontaje() {
		return tiempoMontaje;
	}
	public void setTiempoMontaje(float tiempoMontaje) {
		this.tiempoMontaje = tiempoMontaje;
	}

}
