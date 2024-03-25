package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.NativeQuery;

import configuration.HibernateUtil;
import entity.Partita;

public class PartitaDaoImpl implements InterfacciaDao<Partita>{

	@Override
	public void save(Partita obj) {
		
		Transaction t = null;

		try {

			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();

			t = s.beginTransaction();

			s.save(obj);

			t.commit();

			s.close();

		} catch (ConstraintViolationException e) {

			System.out.println("Valore di chiave primaria duplicato per la tabella Partita");
			e.printStackTrace();
			t.rollback();

		} catch (HibernateException e) {

			System.out.println("Eccezione specifica di Hibernate durante la query");
			e.printStackTrace();
			t.rollback();

		} catch (Exception e) {

			System.out.println("Eccezione generica");
			e.printStackTrace();
			t.rollback();

		}
		
	}

	@Override
	public List<Partita> readAll() {
		
		List<Partita> lista = new ArrayList<>();

		try {

			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();

			lista = s.createQuery("FROM Partita", Partita.class).list();

		} catch (HibernateException e) {

			System.out.println("Eccezione specifica di Hibernate durante la query");
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println("Eccezione generica");
			e.printStackTrace();

		}

		return lista;
		
	}

	@Override
	public void delete(int id) {
		
		Transaction t = null;

		try {

			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();

			t = s.beginTransaction();

			NativeQuery<Partita> nq = s.createNativeQuery("DELETE FROM Partita WHERE id = :id", Partita.class);

			nq.setParameter("id", id);
			nq.executeUpdate();

			t.commit();

			s.close();

		} catch (ConstraintViolationException e) {

			System.out.println("Valore di chiave primaria duplicato per la tabella Partita");
			e.printStackTrace();
			t.rollback();

		} catch (HibernateException e) {

			System.out.println("Eccezione specifica di Hibernate durante la query");
			e.printStackTrace();
			t.rollback();

		} catch (Exception e) {

			System.out.println("Eccezione generica");
			e.printStackTrace();
			t.rollback();

		}
		
	}

	public void updateDate(int id, String data) {
		
		Transaction t = null;

		try {

			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();

			t = s.beginTransaction();

			NativeQuery<Partita> nq = s.createNativeQuery("UPDATE Partita SET data = :data WHERE id = :id",
					Partita.class);

			nq.setParameter("data", data);
			nq.setParameter("id", id);
			nq.executeUpdate();

			t.commit();

			s.close();

		} catch (ConstraintViolationException e) {

			System.out.println("Valore di chiave primaria duplicato per la tabella Partita");
			e.printStackTrace();
			t.rollback();

		} catch (HibernateException e) {

			System.out.println("Eccezione specifica di Hibernate durante la query");
			e.printStackTrace();
			t.rollback();

		} catch (Exception e) {

			System.out.println("Eccezione generica");
			e.printStackTrace();
			t.rollback();

		}
		
	}
	
}
