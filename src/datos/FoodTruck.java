package datos;

public class FoodTruck extends UnidadVenta{
	
	private String patente;
	private boolean conexionElectrica;
	
	public FoodTruck() {
		//vacio
	}
	
	public FoodTruck(String nombreComercial, float superficie, String codigo, Personal responsable, String patente, boolean conexionElectrica) {
		super(nombreComercial, superficie, codigo, responsable);
		this.patente = patente;
		this.conexionElectrica = conexionElectrica;
	}
	@Override
	public String toString() {
		return "FoodTruck [patente=" + patente + ", conexionElectrica=" + conexionElectrica + "]";
	}
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public boolean isConexionElectrica() {
		return conexionElectrica;
	}
	public void setConexionElectrica(boolean conexionElectrica) {
		this.conexionElectrica = conexionElectrica;
	}

	
}
