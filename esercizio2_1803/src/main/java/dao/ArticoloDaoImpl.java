package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import configuration.HibernateUtil;
import entity.Articolo;

public class ArticoloDaoImpl implements InterfacciaDao<Articolo> {

	@Override
	public List<Articolo> findAll() {

		List<Articolo> listaArticoli = new ArrayList<>();

		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();

			listaArticoli = session.createQuery("from Articolo", Articolo.class).list();

			session.close();

		} catch (HibernateException e) {

			System.out.println("Eccezione specifica di Hibernate durante la query");
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println("Eccezione generica");
			e.printStackTrace();

		}

		return listaArticoli;

	}

	@Override
	public Articolo findOne(int codArt) {

		Articolo articolo = null;

		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();

			Query<Articolo> query = session.createQuery("from Articolo where codice_articolo= :codArt", Articolo.class);
			query.setParameter("codArt", codArt);
			articolo = query.getSingleResult();

			session.close();

		} catch (HibernateException e) {

			System.out.println("Eccezione specifica di Hibernate durante la query");
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println("Eccezione generica");
			e.printStackTrace();

		}

		return articolo;

	}

	@Override
	public void insertMany(List<Articolo> listaArticoli) {

		Transaction transaction = null;

		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			for (Articolo x : listaArticoli) {
				session.save(x);
			}

			transaction.commit();

			session.close();

		} catch (ConstraintViolationException e) {

			System.out.println("Valore di chiave primaria duplicato per la tabella Articolo");
			e.printStackTrace();
			transaction.rollback();

		} catch (HibernateException e) {

			System.out.println("Eccezione specifica di Hibernate durante la query");
			e.printStackTrace();
			transaction.rollback();

		} catch (Exception e) {

			System.out.println("Eccezione generica");
			e.printStackTrace();
			transaction.rollback();

		}

	}

	@Override
	public void update(int codArt, String descrizione) {

		Transaction transaction = null;

		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			NativeQuery<Articolo> s = session.createNativeQuery(
					"UPDATE Articolo SET descrizione = :descrizioneWHERE codice_articolo = :codArt", Articolo.class);

			s.setParameter("descrizione", descrizione);
			s.setParameter("codArt", codArt);
			s.executeUpdate();

			transaction.commit();

			session.close();

		} catch (ConstraintViolationException e) {

			System.out.println("Valore di chiave primaria duplicato per la tabella Articolo");
			e.printStackTrace();
			transaction.rollback();

		} catch (HibernateException e) {

			System.out.println("Eccezione specifica di Hibernate durante la query");
			e.printStackTrace();
			transaction.rollback();

		} catch (Exception e) {

			System.out.println("Eccezione generica");
			e.printStackTrace();
			transaction.rollback();

		}

	}

	@Override
	public void delete(int codArt) {

		Transaction transaction = null;

		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			NativeQuery<Articolo> s = session.createNativeQuery("DELETE FROM Articolo WHERE codArt = :codArt", Articolo.class);

			s.setParameter("codArt", codArt);
			s.executeUpdate();

			transaction.commit();

			session.close();

		} catch (ConstraintViolationException e) {

			System.out.println("Valore di chiave primaria duplicato per la tabella Articolo");
			e.printStackTrace();
			transaction.rollback();

		} catch (HibernateException e) {

			System.out.println("Eccezione specifica di Hibernate durante la query");
			e.printStackTrace();
			transaction.rollback();

		} catch (Exception e) {

			System.out.println("Eccezione generica");
			e.printStackTrace();
			transaction.rollback();

		}

	}

}
