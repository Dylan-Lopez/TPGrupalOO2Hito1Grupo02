package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import dao.HibernateUtil;

import datos.Costo;

public class CostoDao {

	
	private static Session session;
	private Transaction tx;
	
	
	private void iniciarOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("ERROR en la capa de acceso a datos", he);
	}
	
	public Costo traerCosto(int IdCosto)
	{
		Costo c = null;
		
		try {
			
			iniciarOperacion();
			c= (Costo) session.get(Costo.class,IdCosto);
			
		}finally {
		session.close();
		}
		
		return c;
		
	}
	
	
}
