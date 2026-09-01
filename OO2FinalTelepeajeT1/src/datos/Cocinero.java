package datos;

import java.time.LocalDate;

public class Cocinero extends Personal {
	private String especialidad;
	private float categoria;

	public Cocinero() {
	}

	public Cocinero(String nombre, String apellido, long dni, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, double sueldoBase, String especialidad, float categoria) throws Exception {
		super(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase);
		this.especialidad = especialidad;
		this.categoria = categoria;
	}

	public String getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public float getCategoria() {
		return categoria;
	}

	public void setCategoria(float categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return super.toString() + ", Cocinero [especialidad=" + especialidad + ", categoria=" + categoria + "]";
	}
}
