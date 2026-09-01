package datos;

import java.util.Set;

public class UnidadVenta {
	private int idUnidadVenta;
	private String nombreComercial;
	private float superficie;
	private String codigo;
	private Personal responsable;
	private Set<Personal> lstStaff;
	//private Set<Plato> lstPlatos;
	//private Set<Pedido> lstPedidos;
	
	public UnidadVenta() {
		//Constructor vacio
	}
	
	public UnidadVenta(String nombreComercial, float superficie, String codigo, Personal responsable) {
		super();
		this.nombreComercial = nombreComercial;
		this.superficie = superficie;
		this.codigo = codigo;
		this.responsable = responsable;
		
	}
	
	public int getId() {
		return idUnidadVenta;
	}
	protected void setId(int idUnidadVenta) {
		this.idUnidadVenta = idUnidadVenta;
	}
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	public float getSuperficie() {
		return superficie;
	}
	public void setSuperficie(float superficie) {
		this.superficie = superficie;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Personal getResponsable() {
		return responsable;
	}
	public void setResponsable(Personal responsable) {
		responsable = responsable;
	}
	public Set<Personal> getLstStaff() {
		return lstStaff;
	}
	public void setLstStaff(Set<Personal> lstStaff) {
		this.lstStaff = lstStaff;
	}
	/*public Set<Plato> getLstPlatos() {
	
		return lstPlatos;
	}
	public void setLstPlatos(Set<Plato> lstPlatos) {
		this.lstPlatos = lstPlatos;
	}
	*/
	@Override
	public String toString() {
		return "UnidadVenta [id=" + idUnidadVenta + ", nombreComercial=" + nombreComercial + ", superficie=" + superficie
				+ ", codigo=" + codigo + ", Responsable=" + responsable + ", lstStaff=" + lstStaff + ", lstPlatos="
				+ /*lstPlatos + */"]";
	}

		
}
