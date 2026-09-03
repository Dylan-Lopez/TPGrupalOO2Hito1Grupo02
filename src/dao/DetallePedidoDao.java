package dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.DetallePedido;
import datos.Pedido;

public class DetallePedidoDao {

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

	public int agregar(DetallePedido objeto) {
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

	public DetallePedido traer(long idDetalle) {
		DetallePedido objeto = null;

		try {
			iniciaOperacion();

			String hql =
	                "from DetallePedido d "  + "inner join fetch d.pedido p "  + "inner join fetch d.plato pl " + "where d.idDetalle = :idDetalle";

	        objeto = session.createQuery(hql, DetallePedido.class)
	                .setParameter("idDetalle", idDetalle)
	                .uniqueResult();


		} finally {
			session.close();
		}

		return objeto;
	}

	public List<DetallePedido> traer(Pedido pedido) throws HibernateException {

		List<DetallePedido> lista = null;

		try {
			iniciaOperacion();

			lista = session.createQuery(
					"select d from DetallePedido d " + "join fetch d.plato " + "where d.pedido.idPedido = :idPedido",
					DetallePedido.class)
					.setParameter("idPedido", pedido.getIdPedido())
					.getResultList();

		} finally {
			session.close();
		}

		return lista;
	}
	
	public List<DetallePedido> traerPorPlato(int idPlato) throws HibernateException {

		List<DetallePedido> lista = null;

		try {

			iniciaOperacion();

			String hql = "from DetallePedido d " + "join fetch d.plato " + "where d.plato.idPlato = :idPlato";

			lista = session.createQuery(hql, DetallePedido.class).setParameter("idPlato", idPlato).getResultList();

		} finally {

			session.close();
		}

		return lista;
	}
	
	
	public void actualizar(DetallePedido objeto) {
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

	public void eliminar(DetallePedido objeto) {
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

}
