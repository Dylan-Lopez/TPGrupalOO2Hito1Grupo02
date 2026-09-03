package dao;

import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import datos.DetallePedido;

import java.time.LocalDate;
import datos.Pedido;

public class PedidoDao {

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

	public int agregar(Pedido objeto) {
		int id = 0;

		try {
			iniciaOperacion();
			id = Integer.parseInt(session.save(objeto).toString());
			tx.commit();

		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;

		} finally {
			session.close();
		}

		return id;
	}

	public void actualizar(Pedido objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();

		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;

		} finally {
			session.close();
		}
	}

	public void eliminar(Pedido objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();

		} catch (HibernateException he) {
			manejaExcepcion(he);
			throw he;

		} finally {
			session.close();
		}
	}

	public Pedido traer(long idPedido) {
		Pedido objeto = null;

		try {
			iniciaOperacion();
			objeto = (Pedido) session.get(Pedido.class, idPedido);

		} finally {
			session.close();
		}

		return objeto;
	}

	public Pedido traerPedidoYDetalles(long idPedido) throws HibernateException {

		Pedido objeto = null;

		try {
			iniciaOperacion();

			String hql = "from Pedido p where p.idPedido = :idPedido";

			objeto = (Pedido) session.createQuery(hql)
					.setParameter("idPedido", idPedido)
					.uniqueResult();

			Hibernate.initialize(objeto.getLstDetalles());

			for (DetallePedido detalle : objeto.getLstDetalles()) {
				Hibernate.initialize(detalle.getPlato());
			}

		} finally {
			session.close();
		}

		return objeto;
	}

	public List<Pedido> traer() throws HibernateException {
		List<Pedido> lista = null;

		try {
			iniciaOperacion();

			lista = session
					.createQuery("from Pedido p order by p.fechaTransaccion asc", Pedido.class)
					.getResultList();

		} finally {
			session.close();
		}

		return lista;
	}
	
	public List<Pedido> traerPedidosPorUnidad(
	        int idUnidad) throws HibernateException {

	    List<Pedido> lista = null;

	    try {
	        iniciaOperacion();

	        lista = session.createQuery(
	            "from Pedido p " +
	            "where p.unidadVenta.idUnidad = :idUnidad ",
	            Pedido.class)
	            .setParameter("idUnidad", idUnidad)
	            .getResultList();

	    } finally {
	        session.close();
	    }

	    return lista;
	}
	
	public List<Pedido> traerPedidosPorUnidadEntreFechas(
	        int idUnidad,
	        LocalDate fechaDesde,
	        LocalDate fechaHasta) throws HibernateException {

	    List<Pedido> lista = null;

	    try {
	        iniciaOperacion();

	        lista = session.createQuery(
	                "from Pedido p " +
	                "where p.unidadVenta.idUnidad = :idUnidad " +
	                "and p.fechaTransaccion between :fechaDesde and :fechaHasta " +
	                "order by p.fechaTransaccion asc",
	                Pedido.class)
	                .setParameter("idUnidad", idUnidad)
	                .setParameter("fechaDesde", fechaDesde)
	                .setParameter("fechaHasta", fechaHasta)
	                .getResultList();

	    } finally {
	        session.close();
	    }

	    return lista;
	}
}
