package dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Festival;

public class FestivalDao {
	
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

    public int agregar(Festival objeto) {
        int id = 0;
        try {
            iniciarOperacion();
            id = Integer.parseInt(session.save(objeto).toString());
            tx.commit();
        } catch (HibernateException he) {
            manejaExcepcion(he);
        } finally {
            session.close();
        }
        return id;
    }

    public Festival traer(int idFestival) {
        Festival objeto = null;
        try {
            iniciarOperacion();
            objeto = (Festival) session.get(Festival.class, idFestival);
        } finally {
            session.close();
        }
        return objeto;
    }
	
}
