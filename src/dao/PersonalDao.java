package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Personal;
import datos.Cajero;
import datos.Cocinero;

public class PersonalDao {

	private static PersonalDao instancia;

	protected PersonalDao() {
	}

	public static PersonalDao getInstancia() {
		if (instancia == null) {
			instancia = new PersonalDao();
		}
		return instancia;
	}

	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}

	public int agregar(Personal objeto) {
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

	public void actualizar(Personal objeto) {
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

	public void eliminar(Personal objeto) {
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

	public Personal traer(long idPersonal) {
		Personal objeto = null;
		try {
			iniciaOperacion();
			objeto = (Personal) session.get(Personal.class, idPersonal);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return objeto;
	}

	public Personal traerPorDni(long dni) {
		Personal personal = null;
		try {
			iniciaOperacion();
			personal = (Personal) session.createQuery("from Personal p where p.dni = :dni")
					.setParameter("dni", dni)
					.uniqueResult();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return personal;
	}

	public List<Personal> traer() {
		List<Personal> lista = new ArrayList<Personal>();
		try {
			iniciaOperacion();
			Query<Personal> query = session.createQuery("from Personal p order by p.apellido asc, p.nombre asc",
					Personal.class);
			lista = query.getResultList();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return lista;
	}

	public List<Cajero> traerCajeros() {
		List<Cajero> lista = new ArrayList<Cajero>();
		try {
			iniciaOperacion();
			Query<Cajero> query = session.createQuery("from Cajero c order by c.apellido asc, c.nombre asc",
					Cajero.class);
			lista = query.getResultList();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return lista;
	}

	public List<Cocinero> traerCocineros() {
		List<Cocinero> lista = new ArrayList<Cocinero>();
		try {
			iniciaOperacion();
			Query<Cocinero> query = session.createQuery("from Cocinero c order by c.apellido asc, c.nombre asc",
					Cocinero.class);
			lista = query.getResultList();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return lista;
	}

	public List<Personal> traer(LocalDate desde, LocalDate hasta) {
		List<Personal> lista = new ArrayList<Personal>();
		try {
			iniciaOperacion();
			Query<Personal> query = session.createQuery(
					"from Personal p where p.fechaNacimiento >= :desde and p.fechaNacimiento <= :hasta order by p.fechaNacimiento asc",
					Personal.class)
					.setParameter("desde", desde)
					.setParameter("hasta", hasta);
			lista = query.getResultList();
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return lista;
	}
}
