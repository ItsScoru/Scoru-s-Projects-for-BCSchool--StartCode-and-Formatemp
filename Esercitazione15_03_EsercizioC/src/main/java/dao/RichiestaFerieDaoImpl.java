package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.Query;

import configuration.HibernateUtil;
import entity.RichiestaFerie;

public class RichiestaFerieDaoImpl implements InterfacciaDao<RichiestaFerie> {

	@Override
	public List<RichiestaFerie> findAll() {

		List<RichiestaFerie> listaRichieste = new ArrayList<>();

		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();

			listaRichieste = session.createQuery("from RichiestaFerie", RichiestaFerie.class).list();

			session.close();

		} catch (HibernateException e) {

			System.out.println("Eccezione specifica di Hibernate durante la query");
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println("Eccezione generica");
			e.printStackTrace();

		}

		return listaRichieste;

	}

	@Override
	public RichiestaFerie findOne(int id) {

		RichiestaFerie richiestaFerie = null;

		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();

			Query<RichiestaFerie> query = session.createQuery("from RichiestaFerie where id = :id", RichiestaFerie.class);
			query.setParameter("id", id);
			richiestaFerie = query.getSingleResult();

			session.close();

		} catch (HibernateException e) {

			System.out.println("Eccezione specifica di Hibernate durante la query");
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println("Eccezione generica");
			e.printStackTrace();

		}

		return richiestaFerie;

	}

	@Override
	public void insertMany(List<RichiestaFerie> listaRichieste) {

		Transaction transaction = null;

		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			for (RichiestaFerie richiesta : listaRichieste) {
				session.save(richiesta);
			}

			transaction.commit();

			session.close();

		} catch (ConstraintViolationException e) {

			System.out.println("Valore di chiave primaria duplicato per la tabella RichiestaFerie");
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
