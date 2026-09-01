package datos;

public class Plato {
	
    private int idPlato;
    private String nombre;
    private float precio;
    private float costoDeProduccion;

    public Plato() {}

    public Plato(String nombre, float precio, float costoDeProduccion) {
        this.nombre = nombre;
        this.precio = precio;
        this.costoDeProduccion = costoDeProduccion;
    }

	public int getIdPlato() {
		return idPlato;
	}

	protected void setIdPlato(int idPlato) {
		this.idPlato = idPlato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getCostoDeProduccion() {
		return costoDeProduccion;
	}

	public void setCostoDeProduccion(float costoDeProduccion) {
		this.costoDeProduccion = costoDeProduccion;
	}
	
    @Override
    public String toString() {
        return "Plato [idPlato=" + idPlato + ", nombre=" + nombre + ", precio=" + precio + ", costoDeProduccion="
                + costoDeProduccion + "]";
    }
	
	
	

}
