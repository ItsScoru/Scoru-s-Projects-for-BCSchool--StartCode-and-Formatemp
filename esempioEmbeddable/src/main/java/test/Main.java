package test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;

import configuration.HibernateUtil;
import entity.Indirizzo;
import entity.Utente;

public class Main {
	
	public static void main(String[] args) {
		
		Transaction transaction = null;
		Session session = null;
		
		Indirizzo indirizzo = new Indirizzo("Viale via", "Milano", "Italia", 303030);
		Utente utente = new Utente("Mario", "Rossi", "email.com", indirizzo);

		try {

			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();

			transaction = session.beginTransaction();

			session.save(utente);

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
