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
import entity.Stadio;

public class StadioDaoImpl implements InterfacciaDao<Stadio>{

	@Override
	public void save(Stadio obj) {
		
		Transaction t = null;

		try {

			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();

			t = s.beginTransaction();

			s.save(obj);

			t.commit();

			s.close();

		} catch (ConstraintViolationException e) {

			System.out.println("Valore di chiave primaria duplicato per la tabella Stadio");
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
	public List<Stadio> readAll() {
		
		List<Stadio> lista = new ArrayList<>();

		try {

			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();

			lista = s.createQuery("FROM Stadio", Stadio.class).list();

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

			NativeQuery<Stadio> nq = s.createNativeQuery("DELETE FROM Stadio WHERE id = :id", Stadio.class);

			nq.setParameter("id", id);
			nq.executeUpdate();

			t.commit();

			s.close();

		} catch (ConstraintViolationException e) {

			System.out.println("Valore di chiave primaria duplicato per la tabella Stadio");
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
