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
import entity.Acquirente;

public class AcquirenteDaoImpl implements InterfacciaDao<Acquirente> {

    @Override
    public void insertMany(List<Acquirente> lista) {

        Transaction transaction = null;

        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            for (Acquirente x : lista) {
                session.save(x);
            }

            transaction.commit();

            session.close();

        } catch (ConstraintViolationException e) {

            System.out.println("Valore di chiave primaria duplicato per la tabella Acquirente");
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

    @Override
    public List<Acquirente> findAll() {

        List<Acquirente> lista = new ArrayList<>();

        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            lista = session.createQuery("FROM Acquirente", Acquirente.class).list();

            session.close();

        } catch (HibernateException e) {

            System.out.println("Eccezione specifica di Hibernate durante la query");
            e.printStackTrace();

        } catch (Exception e) {

            System.out.println("Eccezione generica");
            e.printStackTrace();

        }

        return lista;

    }

    public void delete(String codice_fiscale) {

        Transaction transaction = null;

        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            NativeQuery<Acquirente> nq = session.createNativeQuery("DELETE FROM Acquirente WHERE codice_fiscale = :codice_fiscale",
                    Acquirente.class);

            nq.setParameter("codice_fiscale", codice_fiscale);
            nq.executeUpdate();

            transaction.commit();

            session.close();

        } catch (ConstraintViolationException e) {

            System.out.println("Valore di chiave primaria duplicato per la tabella Acquirente");
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

    public void updateTel(int id, String num) {

        Transaction transaction = null;

        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            Acquirente aq = session.find(Acquirente.class, id);
            aq.setTel(num);

            transaction.commit();

            session.close();

        } catch (ConstraintViolationException e) {

			System.out.println("Valore di chiave primaria duplicato per la tabella Aquirente");
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
    
    public void insert(Acquirente ogg) {

        Transaction transaction = null;

        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            session.save(ogg);

            transaction.commit();

            session.close();

        } catch (ConstraintViolationException e) {

            System.out.println("Valore di chiave primaria duplicato per la tabella Acquirente");
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
