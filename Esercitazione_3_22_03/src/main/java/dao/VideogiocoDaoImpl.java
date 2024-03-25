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
import entity.Videogioco;

public class VideogiocoDaoImpl implements InterfacciaDao<Videogioco>{

	@Override
	public void save(Videogioco obj) {
		
		Transaction t = null;

		try {

			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();

			t = s.beginTransaction();

			s.save(obj);

			t.commit();

			s.close();

		} catch (ConstraintViolationException e) {

			System.out.println("Valore di chiave primaria duplicato per la tabella Videogioco");
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
	public List<Videogioco> readAll() {
		
		List<Videogioco> lista = new ArrayList<>();

		try {

			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();

			lista = s.createQuery("FROM Videogioco", Videogioco.class).list();

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

			NativeQuery<Videogioco> nq = s.createNativeQuery("DELETE FROM Videogioco WHERE id = :id", Videogioco.class);

			nq.setParameter("id", id);
			nq.executeUpdate();

			t.commit();

			s.close();

		} catch (ConstraintViolationException e) {

			System.out.println("Valore di chiave primaria duplicato per la tabella Videogioco");
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
	public void updateName(int id, String nome) {
		
		Transaction t = null;

		try {

			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();

			t = s.beginTransaction();

			NativeQuery<Videogioco> nq = s.createNativeQuery("UPDATE Personaggio SET nome = :nome WHERE id = :id",
					Videogioco.class);

			nq.setParameter("nome", nome);
			nq.setParameter("id", id);
			nq.executeUpdate();

			t.commit();

			s.close();

		} catch (ConstraintViolationException e) {

			System.out.println("Valore di chiave primaria duplicato per la tabella Videogioco");
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
