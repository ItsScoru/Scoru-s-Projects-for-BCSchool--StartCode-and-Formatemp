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
import entity.Capitano;

public class CapitanoDaoImpl implements InterfacciaDao<Capitano> {

	@Override
	public void save(Capitano obj) {

		Transaction t = null;

		try {

			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();

			t = s.beginTransaction();

			s.save(obj);

			t.commit();

			s.close();

		} catch (ConstraintViolationException e) {

			System.out.println("Valore di chiave primaria duplicato per la tabella Capitano");
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
	public List<Capitano> readAll() {

		List<Capitano> lista = new ArrayList<>();

		try {

			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();

			lista = s.createQuery("FROM Capitano", Capitano.class).list();

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

			NativeQuery<Capitano> nq = s.createNativeQuery("DELETE FROM Capitano WHERE id = :id", Capitano.class);

			nq.setParameter("id", id);
			nq.executeUpdate();

			t.commit();

			s.close();

		} catch (ConstraintViolationException e) {

			System.out.println("Valore di chiave primaria duplicato per la tabella Capitano");
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
	public void updateName(int id, String name) {

		Transaction t = null;

		try {

			SessionFactory sf = HibernateUtil.getSessionFactory();
			Session s = sf.openSession();

			t = s.beginTransaction();

			NativeQuery<Capitano> nq = s.createNativeQuery("UPDATE Capitano SET nome = :nome WHERE id = :id",
					Capitano.class);

			nq.setParameter("nome", name);
			nq.setParameter("id", id);
			nq.executeUpdate();

			t.commit();

			s.close();

		} catch (ConstraintViolationException e) {

			System.out.println("Valore di chiave primaria duplicato per la tabella Capitano");
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
