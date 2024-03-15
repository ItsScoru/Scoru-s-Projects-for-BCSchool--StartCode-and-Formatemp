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
import entity.Studente;

public class StudenteDaoImpl implements InterfacciaDao<Studente>{

	@Override
	public List<Studente> findAll() {

		List<Studente> listaStudenti = new ArrayList<>();

		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();

			listaStudenti = session.createQuery("from Studente", Studente.class).list();

			session.close();

		} catch (HibernateException e) {

			System.out.println("Eccezione specifica di Hibernate durante la query");
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println("Eccezione generica");
			e.printStackTrace();

		}

		return listaStudenti;
		
	}

	@Override
	public Studente findOne(int id) {
		
		Studente studente = null;

		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();

			Query<Studente> query = session.createQuery("from Studente where id = :id", Studente.class);
			query.setParameter("id", id);
			studente = query.getSingleResult();

			session.close();

		} catch (HibernateException e) {

			System.out.println("Eccezione specifica di Hibernate durante la query");
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println("Eccezione generica");
			e.printStackTrace();

		}

		return studente;
		
	}

	@Override
	public void insertMany(List<Studente> listaStudenti) {
		
		Transaction transaction = null;

		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			for (Studente x : listaStudenti) {
				session.save(x);
			}

			transaction.commit();

			session.close();

		} catch (ConstraintViolationException e) {

			System.out.println("Valore di chiave primaria duplicato per la tabella Studente");
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
