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
import entity.Corso;

public class CorsoDaoImpl implements InterfacciaDao<Corso>{

	@Override
	public List<Corso> findAll() {
		
		List<Corso> listaCorsi = new ArrayList<>();

		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();

			listaCorsi = session.createQuery("from Corso", Corso.class).list();

			session.close();

		} catch (HibernateException e) {

			System.out.println("Eccezione specifica di Hibernate durante la query");
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println("Eccezione generica");
			e.printStackTrace();

		}

		return listaCorsi;
		
	}

	@Override
	public Corso findOne(int id) {
		
		Corso corso = null;

		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();

			Query<Corso> query = session.createQuery("from Corso where id = :id", Corso.class);
			query.setParameter("id", id);
			corso = query.getSingleResult();

			session.close();

		} catch (HibernateException e) {

			System.out.println("Eccezione specifica di Hibernate durante la query");
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println("Eccezione generica");
			e.printStackTrace();

		}

		return corso;
		
	}

	@Override
	public void insertMany(List<Corso> listaCorsi) {
		
		Transaction transaction = null;

		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			Session session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			for (Corso x : listaCorsi) {
				session.save(x);
			}

			transaction.commit();

			session.close();

		} catch (ConstraintViolationException e) {

			System.out.println("Valore di chiave primaria duplicato per la tabella Corsi");
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
