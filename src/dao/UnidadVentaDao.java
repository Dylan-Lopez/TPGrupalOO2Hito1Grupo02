package dao;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.UnidadVenta;
import datos.FoodTruck;
import datos.PuestoDesarmable;

public class UnidadVentaDao {
	private static Session session;
	private Transaction tx;
	private static UnidadVentaDao instancia = null;

	protected UnidadVentaDao() {
	}

	public static UnidadVentaDao getInstancia() {
		if (instancia == null) {
			instancia = new UnidadVentaDao();
		}
		return instancia;
	}
	
	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public int agregar(UnidadVenta objeto) {
		int id = 0;
		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return id;
	}

	public void actualizar(UnidadVenta objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public void eliminar(UnidadVenta objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			if (session != null) {
				session.close();
			}
		}
	}

	public UnidadVenta traer(int idUnidadVenta) {
		UnidadVenta objeto = null;
		try {
			iniciaOperacion();
			objeto = (UnidadVenta) session.get(UnidadVenta.class, idUnidadVenta);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return objeto;
	}

	public UnidadVenta traerPorCodigo(String codigo) {
		UnidadVenta objeto = null;
		try {
			iniciaOperacion();
			objeto = (UnidadVenta) session.createQuery("from UnidadVenta u where u.codigo = :codigo")
					.setParameter("codigo", codigo)
					.uniqueResult();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return objeto;
	}

	public List<FoodTruck> traerFoodTrucks() {
		List<FoodTruck> lista = new ArrayList<FoodTruck>();
		try {
			iniciaOperacion();
			Query<FoodTruck> query = session.createQuery(
					"from FoodTruck f order by f.nombreComercial asc", FoodTruck.class);
			lista = query.getResultList();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return lista;
	}

	public List<PuestoDesarmable> traerPuestosDesarmables() {
		List<PuestoDesarmable> lista = new ArrayList<PuestoDesarmable>();
		try {
			iniciaOperacion();
			Query<PuestoDesarmable> query = session.createQuery(
					"from PuestoDesarmable p order by p.nombreComercial asc", PuestoDesarmable.class);
			lista = query.getResultList();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return lista;
	}

	public List<UnidadVenta> traer() {
		List<UnidadVenta> lista = new ArrayList<UnidadVenta>();
		try {
			iniciaOperacion();
			Query<UnidadVenta> query = session.createQuery(
					"from UnidadVenta u order by u.nombreComercial asc", UnidadVenta.class);
			lista = query.getResultList();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return lista;
	}

	//Nuevo
	public UnidadVenta traerUnidadYStaff(int idUnidadVenta) throws HibernateException {

		UnidadVenta objeto = null;

		try {

			iniciaOperacion();

			objeto = session.get(UnidadVenta.class, idUnidadVenta);

			if (objeto != null) {
				Hibernate.initialize(objeto.getLstStaff());
			}

		} finally {

			session.close();
		}

		return objeto;
	}

}
