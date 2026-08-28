package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	
	ClienteDao dao = new ClienteDao();

	public Cliente traer(long idCliente) {
		return dao.traer(idCliente);
	}

	public Cliente traer(int dni) {
		return dao.traer(dni);
	}

	public int agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) throws Exception {
		//Excepcion por cliente duplicado
		if(traer(dni) != null)throw new Exception("ERROR ya existe cliente con DNI: " + dni);
		Cliente c = new Cliente(apellido, nombre, dni, fechaDeNacimiento);
		return dao.agregar(c);
	}

	public void modificar(Cliente c) {
		/*
		 * En caso de editar el dni, antes de actualizar, validar que no exista un cliente con el mismo dni
		 * y si eso pasa lanzar la Exception
		 */
		dao.actualizar(c);
	}

	public void eliminar(long idCliente) {
		/*
		 * En este caso la baja es física y sabemos que la entidad no tiene relaciones
		 * pero en caso de tenerlas, hay que validar que el cliente no tenga dependencias que generen errores al borrarlo.
		 */
		Cliente c = dao.traer(idCliente);
		// Implementar que si es null que arroje la excepción la Excepción de que el cliente no existe
		dao.eliminar(c);
	}

	public List<Cliente> traer() {
		return dao.traer();
	}
}
