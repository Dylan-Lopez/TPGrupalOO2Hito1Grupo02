package datos;

public class PuestoDesarmable extends UnidadVenta{
	
	private int cantidadCarpas;
	private int timepoMontaje;
	
	public PuestoDesarmable() {
		//vacio
	}
	
	public PuestoDesarmable(String nombreComercial, float superficie, String codigo, Personal responsable, int cantidadCarpas, int tiempoMontaje) {
		super(nombreComercial, superficie, codigo, responsable);
		this.cantidadCarpas = cantidadCarpas;
		this.timepoMontaje = timepoMontaje;
	}
	
	@Override
	public String toString() {
		return "PuestoDesarmable [cantidadCarpas=" + cantidadCarpas + ", timepoMontaje=" + timepoMontaje + "]";
	}
	public int getCantidadCarpas() {
		return cantidadCarpas;
	}
	public void setCantidadCarpas(int cantidadCarpas) {
		this.cantidadCarpas = cantidadCarpas;
	}
	public int getTimepoMontaje() {
		return timepoMontaje;
	}
	public void setTimepoMontaje(int timepoMontaje) {
		this.timepoMontaje = timepoMontaje;
	}

}
