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
import entity.Parco;

public class ParcoDaoImpl implements InterfacciaDao<Parco>{

	@Override
	public void insert(Parco istanza) {
		
		Transaction t = null;

		try {

			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();

			t = s.beginTransaction();

			s.save(istanza);

			t.commit();

			s.close();

		} catch (ConstraintViolationException e) {

			System.out.println("Valore di chiave primaria duplicato per la tabella Parco");
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
	public List<Parco> findAll() {
		
		List<Parco> listaParchi = new ArrayList<>();

		try {

			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();

			listaParchi = s.createQuery("FROM Parco", Parco.class).list();

		} catch (HibernateException e) {

			System.out.println("Eccezione specifica di Hibernate durante la query");
			e.printStackTrace();

		} catch (Exception e) {

			System.out.println("Eccezione generica");
			e.printStackTrace();

		}
		
		return listaParchi;
		
	}

	@Override
	public void delete(int id) {
		
		Transaction t = null;

		try {

			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();

			t = s.beginTransaction();

			NativeQuery<Parco> nq = s.createNativeQuery("DELETE FROM Parco WHERE id = :id", Parco.class);

			nq.setParameter("id", id);
			nq.executeUpdate();

			t.commit();

			s.close();

		} catch (ConstraintViolationException e) {

			System.out.println("Valore di chiave primaria duplicato per la tabella Parco");
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
	public void update(int id, String name) {
		
Transaction t = null;
		
		try {
			
			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();
			
			t = s.beginTransaction();
			
			NativeQuery<Parco> nq = s.createNativeQuery("UPDATE Parco SET nome = :nome WHERE id = :id", Parco.class);
			
			nq.setParameter("nome", name);
			nq.setParameter("id", id);
			nq.executeUpdate();
			
			t.commit();
			
			s.close();
			
		} catch (ConstraintViolationException e) {

			System.out.println("Valore di chiave primaria duplicato per la tabella Parco");
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
