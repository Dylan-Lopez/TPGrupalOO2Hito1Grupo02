package datos;

import java.time.LocalDate;
import java.time.Period;

public abstract class Personal {
	protected long idPersonal;
	protected String nombre;
	protected String apellido;
	protected long dni;
	protected LocalDate fechaNacimiento;
	protected LocalDate fechaIngreso;
	protected double sueldoBase;

	public Personal() {
	}

	public Personal(String nombre, String apellido, long dni, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, double sueldoBase) throws Exception {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.setFechaNacimiento(fechaNacimiento);
		this.fechaIngreso = fechaIngreso;
		this.sueldoBase = sueldoBase;
	}

	public long getIdPersonal() {
		return idPersonal;
	}

	protected void setIdPersonal(long idPersonal) {
		this.idPersonal = idPersonal;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public long getDni() {
		return dni;
	}

	public void setDni(long dni) {
		this.dni = dni;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) throws Exception {
		if (fechaNacimiento == null || Period.between(fechaNacimiento, LocalDate.now()).getYears() < 18) {
			throw new Exception("ERROR el personal debe ser mayor de edad.");
		}
		this.fechaNacimiento = fechaNacimiento;
	}

	public LocalDate getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(LocalDate fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public double getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(double sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public int calcularAntiguedad() {
		return Period.between(this.fechaIngreso, LocalDate.now()).getYears();
	}

	public boolean esMayorDeEdad() {
		return Period.between(this.fechaNacimiento, LocalDate.now()).getYears() >= 18;
	}

	@Override
	public String toString() {
		return "Personal [idPersonal=" + idPersonal + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni
				+ ", fechaNacimiento=" + fechaNacimiento + ", fechaIngreso=" + fechaIngreso + ", sueldoBase="
				+ sueldoBase + "]";
	}
}
