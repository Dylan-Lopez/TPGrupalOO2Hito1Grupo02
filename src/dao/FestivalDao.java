package dao;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import datos.Festival;
import datos.Plato;

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
    
    public List<Festival> traerEntreFechas(LocalDate fechaDesde, LocalDate fechaHasta) throws HibernateException {
        List<Festival> lista = null;
        try {
            iniciarOperacion();
            lista = session.createQuery(
                    "from Festival f " +
                    "where f.fechaInicio between :fechaDesde and :fechaHasta " +
                    "order by f.fechaInicio asc",
                    Festival.class)
                    .setParameter("fechaDesde", fechaDesde)
                    .setParameter("fechaHasta", fechaHasta)
                    .getResultList();
        } finally {
            session.close();
        }
        return lista;
    }

    public List<Festival> traerConPlusElectricidad() throws HibernateException {
        List<Festival> lista = null;
        try {
            iniciarOperacion();
            lista = session.createQuery(
                    "from Festival f " +
                    "where f.costo.plusElectricidad > 0 " +
                    "order by f.nombre asc",
                    Festival.class)
                    .getResultList();
        } finally {
            session.close();
        }
        return lista;
    }
    
    public Festival traerFestivalYUnidades(Festival festival) throws HibernateException {
        Festival objeto = null;
        try {
            iniciarOperacion();
            String hql = "from Festival f where f.idFestival = :idFestival";
            objeto = (Festival) session.createQuery(hql)
                    .setParameter("idFestival", festival.getIdFestival())
                    .uniqueResult();
            Hibernate.initialize(objeto.getUnidadesVenta());
        } finally {
            session.close();
        }
        return objeto;
    }

    public List<Plato> traerPlatosPorFestival(Festival festival) throws HibernateException {
        List<Plato> lista = null;
        try {
            iniciarOperacion();
            String hql = "select distinct p from Festival f " +
                    "join f.unidadesVenta uv " +
                    "join uv.lstPlatos p " +
                    "where f.idFestival = :idFestival " +
                    "order by p.nombre asc";
            lista = session.createQuery(hql, Plato.class)
                    .setParameter("idFestival", festival.getIdFestival())
                    .getResultList();
        } finally {
            session.close();
        }
        return lista;
    }

    public Plato traerPlatoMasCaroDeFestival(Festival festival) throws HibernateException {
        Plato masCaro = null;
        try {
            iniciarOperacion();
            String hql = "select distinct p from Festival f " +
                    "join f.unidadesVenta uv " +
                    "join uv.lstPlatos p " +
                    "where f.idFestival = :idFestival " +
                    "order by p.precio desc";
            List<Plato> lista = session.createQuery(hql, Plato.class)
                    .setParameter("idFestival", festival.getIdFestival())
                    .setMaxResults(1)
                    .getResultList();
            if (!lista.isEmpty()) {
                masCaro = lista.get(0);
            }
        } finally {
            session.close();
        }
        return masCaro;
    }
    
	
}
