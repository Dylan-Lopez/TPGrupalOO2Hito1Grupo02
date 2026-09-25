package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.hibernate.Hibernate;

import datos.UnidadVenta;
import datos.FoodTruck;
import datos.PuestoDesarmable;
import datos.Festival;

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

	public UnidadVenta traerUnidadYFestivales(int idUnidadVenta) throws HibernateException {
		UnidadVenta objeto = null;
		try {
			iniciaOperacion();
			objeto = session.get(UnidadVenta.class, idUnidadVenta);
			if (objeto != null) {
				Hibernate.initialize(objeto.getFestivales());
			}
		} finally {
			if (session != null) {
				session.close();
			}
		}
		return objeto;
	}
	
	public List<UnidadVenta> traerPorSuperficieMayorA(float superficieMinima, Festival festival) {
	    List<UnidadVenta> lista = new ArrayList<UnidadVenta>();
	    try {
	        iniciaOperacion();

	        String hql = "select distinct u from UnidadVenta u ";
	        if (festival != null) {
	            hql += "join u.festivales fest ";
	        }
	        hql += "where u.superficie >= :superficieMinima ";
	        if (festival != null) {
	            hql += "and fest = :festival ";
	        }
	        hql += "order by u.superficie asc";

	        Query<UnidadVenta> query = session.createQuery(hql, UnidadVenta.class);
	        query.setParameter("superficieMinima", superficieMinima);
	        if (festival != null) {
	            query.setParameter("festival", festival);
	        }

	        lista = query.getResultList();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return lista;
	}
	
	public List<FoodTruck> traerFoodTrucksConConexion(Festival festival) {
	    List<FoodTruck> lista = new ArrayList<FoodTruck>();
	    try {
	        iniciaOperacion();

	        String hql = "select distinct f from FoodTruck f ";
	        if (festival != null) {
	            hql += "join f.festivales fest ";
	        }
	        hql += "where f.conexionElectrica = true ";
	        if (festival != null) {
	            hql += "and fest = :festival ";
	        }
	        hql += "order by f.nombreComercial asc";

	        Query<FoodTruck> query = session.createQuery(hql, FoodTruck.class);
	        if (festival != null) {
	            query.setParameter("festival", festival);
	        }

	        lista = query.getResultList();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return lista;
	}
	
	public List<FoodTruck> traerFoodTrucksFiltrosConConexionYSuperficie(float superficieMinima, Festival festival) {
	    List<FoodTruck> lista = new ArrayList<FoodTruck>();
	    try {
	        iniciaOperacion();

	        String hql = "select distinct f from FoodTruck f ";
	        if (festival != null) {
	            hql += "join f.festivales fest ";
	        }
	        hql += "where f.superficie > :superficieMinima and f.conexionElectrica = true ";
	        if (festival != null) {
	            hql += "and fest = :festival ";
	        }
	        hql += "order by f.superficie asc";

	        Query<FoodTruck> query = session.createQuery(hql, FoodTruck.class);
	        query.setParameter("superficieMinima", superficieMinima);
	        if (festival != null) {
	            query.setParameter("festival", festival);
	        }

	        lista = query.getResultList();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return lista;
	}
	
	public List<PuestoDesarmable> traerPuestosConMasDeXCarpas(int cantidadMinima, Festival festival) {
	    List<PuestoDesarmable> lista = new ArrayList<PuestoDesarmable>();
	    try {
	        iniciaOperacion();

	        String hql = "select distinct p from PuestoDesarmable p ";
	        if (festival != null) {
	            hql += "join p.festivales fest ";
	        }
	        hql += "where p.cantidadCarpas > :cantidadMinima ";
	        if (festival != null) {
	            hql += "and fest = :festival ";
	        }
	        hql += "order by p.cantidadCarpas asc";

	        Query<PuestoDesarmable> query = session.createQuery(hql, PuestoDesarmable.class);
	        query.setParameter("cantidadMinima", cantidadMinima);
	        if (festival != null) {
	            query.setParameter("festival", festival);
	        }

	        lista = query.getResultList();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return lista;
	}

	public List<PuestoDesarmable> traerPuestosCarpasYMontaje(int cantidadMinima, float tiempoMaximo, Festival festival) {
	    List<PuestoDesarmable> lista = new ArrayList<PuestoDesarmable>();
	    try {
	        iniciaOperacion();

	        String hql = "select distinct p from PuestoDesarmable p ";
	        if (festival != null) {
	            hql += "join p.festivales fest ";
	        }
	        hql += "where p.cantidadCarpas > :cantidadMinima and p.tiempoMontaje < :tiempoMaximo ";
	        if (festival != null) {
	            hql += "and fest = :festival ";
	        }
	        hql += "order by p.cantidadCarpas asc";

	        Query<PuestoDesarmable> query = session.createQuery(hql, PuestoDesarmable.class);
	        query.setParameter("cantidadMinima", cantidadMinima);
	        query.setParameter("tiempoMaximo", tiempoMaximo);
	        if (festival != null) {
	            query.setParameter("festival", festival);
	        }

	        lista = query.getResultList();
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return lista;
	}
}
