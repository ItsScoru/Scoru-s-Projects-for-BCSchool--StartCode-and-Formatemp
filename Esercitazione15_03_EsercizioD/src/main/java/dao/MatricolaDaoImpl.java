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
import entity.Matricola;

public class MatricolaDaoImpl implements InterfacciaDao<Matricola>{

	@Override
	public List<Matricola> findAll() {
		
		List<Matricola> listaMatricole = new ArrayList<>();

		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();

			listaMatricole = session.createQuery("from Matricola", Matricola.class).list();

			session.close();

		} catch (HibernateException e) {

			System.out.println("Eccezione specifica di Hibernate durante la query");
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println("Eccezione generica");
			e.printStackTrace();

		}

		return listaMatricole;
		
	}

	@Override
	public Matricola findOne(int id) {
		
		Matricola matricola = null;

		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();

			Query<Matricola> query = session.createQuery("from Matricola where id = :id", Matricola.class);
			query.setParameter("id", id);
			matricola = query.getSingleResult();

			session.close();

		} catch (HibernateException e) {

			System.out.println("Eccezione specifica di Hibernate durante la query");
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println("Eccezione generica");
			e.printStackTrace();

		}

		return matricola;
		
	}

	@Override
	public void insertMany(List<Matricola> listaMatricole) {
		
		Transaction transaction = null;

		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			for (Matricola x : listaMatricole) {
				session.save(x);
			}

			transaction.commit();

			session.close();

		} catch (ConstraintViolationException e) {

			System.out.println("Valore di chiave primaria duplicato per la tabella Matricola");
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
