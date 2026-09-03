package datos;

public class Costo {
	
	
	private int idCosto;
	private float costoSuperficie;
	private float costoMontaje;
	private float plusElectricidad;
	
	public Costo() {}
	
	public Costo(float costoSuperficie, float costoMontaje,float plusElectricidad)
	{
		this.costoSuperficie = costoSuperficie;
		this.costoMontaje = costoMontaje;
		this.plusElectricidad = plusElectricidad;
	}

	public int getIdCosto() {
		return idCosto;
	}

	protected void setIdCosto(int idCosto) {
		this.idCosto = idCosto;
	}

	public float getCostoSuperficie() {
		return costoSuperficie;
	}

	public void setCostoSuperficie(float costoSuperficie) {
		this.costoSuperficie = costoSuperficie;
	}

	public float getCostoMontaje() {
		return costoMontaje;
	}

	public void setCostoMontaje(float costoMontaje) {
		this.costoMontaje = costoMontaje;
	}

	public float getPlusElectricidad() {
		return plusElectricidad;
	}

	public void setPlusElectricidad(float plusElectricidad) {
		this.plusElectricidad = plusElectricidad;
	}
	
	
    @Override
    public String toString() {
        return "Costo [idCosto=" + idCosto + ", costoSuperficie=" + costoSuperficie + ", costoMontaje="
                + costoMontaje + ", plusElectricidad=" + plusElectricidad + "]";
    }
	
	
	
	
	

}
