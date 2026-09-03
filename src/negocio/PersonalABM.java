package negocio;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import dao.PersonalDao;
import datos.Personal;
import datos.Cajero;
import datos.Cocinero;

public class PersonalABM {

	private PersonalDao dao = PersonalDao.getInstancia();

	public Personal traer(long idPersonal) {
		return dao.traer(idPersonal);
	}

	public Personal traerPorDni(long dni) {
		return dao.traerPorDni(dni);
	}

	public int agregarCajero(String nombre, String apellido, long dni, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, double sueldoBase, String turno) throws Exception {
		if (traerPorDni(dni) != null) {
			throw new Exception("ERROR ya existe personal con DNI: " + dni);
		}
		Cajero c = new Cajero(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase, turno);
		return dao.agregar(c);
	}

	public int agregarCocinero(String nombre, String apellido, long dni, LocalDate fechaNacimiento,
			LocalDate fechaIngreso, double sueldoBase, String especialidad, float categoria) throws Exception {
		if (traerPorDni(dni) != null) {
			throw new Exception("ERROR ya existe personal con DNI: " + dni);
		}
		Cocinero c = new Cocinero(nombre, apellido, dni, fechaNacimiento, fechaIngreso, sueldoBase, especialidad,
				categoria);
		return dao.agregar(c);
	}

	public void modificar(Personal p) {
		dao.actualizar(p);
	}

	public void eliminar(long idPersonal) throws Exception {
		Personal p = dao.traer(idPersonal);
		if (p == null) {
			throw new Exception("ERROR no existe personal con ID: " + idPersonal);
		}
		dao.eliminar(p);
	}

	public List<Personal> traer() {
		return dao.traer();
	}

	public List<Cajero> traerCajeros() {
		return dao.traerCajeros();
	}

	public List<Cocinero> traerCocineros() {
		return dao.traerCocineros();
	}

	public List<Personal> traer(LocalDate desde, LocalDate hasta) {
		return dao.traer(desde, hasta);
	}
}
