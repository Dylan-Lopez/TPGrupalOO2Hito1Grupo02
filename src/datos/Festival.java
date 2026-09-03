package datos;

import java.time.LocalDate;
import java.util.Set;

public class Festival {

	
	private int idFestival;
	private String nombre;
	private String temporada;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Costo costo;
	private Set<UnidadVenta> listaUnidadesVenta;
	
	public Festival() {}
	
	public Festival(String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin, Costo costo)
	{
        this.nombre = nombre;
        this.temporada = temporada;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costo = costo;
	}

	public int getIdFestival() {
		return idFestival;
	}

	protected void setIdFestival(int idFestival) {
		this.idFestival = idFestival;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTemporada() {
		return temporada;
	}

	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Costo getCosto() {
		return costo;
	}

	public void setCosto(Costo costo) {
		this.costo = costo;
	}
	
	public Set<UnidadVenta> getListaUnidadesVenta() {
		return listaUnidadesVenta;
	}

	public void setListaUnidadesVenta(Set<UnidadVenta> listaUnidadesVenta) {
		this.listaUnidadesVenta = listaUnidadesVenta;
	}
	
    @Override
    public String toString() {
       
        return "Festival [idFestival=" + idFestival + ", nombre=" + nombre + ", temporada=" + temporada
                + ", fechaInicio=" + fechaInicio + ", fechaFin=" + fechaFin + ", costo=" + costo + "]";
    }
	
}
