package datos;

import java.time.LocalDate;

public class Cajero extends Personal {
	private String turno;

	public Cajero() {
	}

	public Cajero(String nombre, String apellido, long dni, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, double sueldoBase, String turno) throws Exception {
		super(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase);
		this.turno = turno;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	@Override
	public String toString() {
		return super.toString() + ", Cajero [turno=" + turno + "]";
	}
}
