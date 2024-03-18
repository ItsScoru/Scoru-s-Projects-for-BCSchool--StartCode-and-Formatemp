package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.exception.ConstraintViolationException;
import org.hibernate.query.NativeQuery;
import org.hibernate.query.Query;

import configuration.HibernateUtil;
import entity.GiocoDaTavolo;

public class GiocoDaTavoloDaoImpl implements InterfacciaDao<GiocoDaTavolo> {

    @Override
    public List<GiocoDaTavolo> findAll() {

        List<GiocoDaTavolo> listaGiochi = new ArrayList<>();

        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            listaGiochi = session.createQuery("from GiocoDaTavolo", GiocoDaTavolo.class).list();

            session.close();

        } catch (HibernateException e) {

            System.out.println("Eccezione specifica di Hibernate durante la query");
            e.printStackTrace();

        } catch (Exception e) {

            System.out.println("Eccezione generica");
            e.printStackTrace();

        }

        return listaGiochi;

    }

    @Override
    public void insertMany(List<GiocoDaTavolo> listaGiochi) {

        Transaction transaction = null;

        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            for (GiocoDaTavolo x : listaGiochi) {
                session.save(x);
            }

            transaction.commit();

            session.close();

        } catch (ConstraintViolationException e) {

            System.out.println("Valore di chiave primaria duplicato per la tabella GiocoDaTavolo");
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
    public void delete(int id) {

        Transaction transaction = null;

        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            NativeQuery<GiocoDaTavolo> s = session.createNativeQuery("DELETE FROM GiocoDaTavolo WHERE id = :id",
                    GiocoDaTavolo.class);

            s.setParameter("id", id);
            s.executeUpdate();

            transaction.commit();

            session.close();

        } catch (ConstraintViolationException e) {

            System.out.println("Valore di chiave primaria duplicato per la tabella GiocoDaTavolo");
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

    public GiocoDaTavolo findOne(String nome) {

        GiocoDaTavolo gioco = null;

        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Query<GiocoDaTavolo> query = session.createQuery("from GiocoDaTavolo where nome LIKE :nome",
                    GiocoDaTavolo.class);
            query.setParameter("nome", nome);
            gioco = query.getSingleResult();

            session.close();

        } catch (HibernateException e) {

            System.out.println("Eccezione specifica di Hibernate durante la query");
            e.printStackTrace();

        } catch (Exception e) {

            System.out.println("Eccezione generica");
            e.printStackTrace();

        }

        return gioco;

    }

    public void updateName(int id, String nome) {

        Transaction transaction = null;

        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            NativeQuery<GiocoDaTavolo> s = session
                    .createNativeQuery("UPDATE GiocoDaTavolo SET nome = :nome WHERE id = :id", GiocoDaTavolo.class);

            s.setParameter("nome", nome);
            s.setParameter("id", id);
            s.executeUpdate();

            transaction.commit();

            session.close();

        } catch (ConstraintViolationException e) {

            System.out.println("Valore di chiave primaria duplicato per la tabella GiocoDaTavolo");
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

    public void updateFull(int id, String nome, String casaProduttrice, int numMinGiocatori, int numMaxGiocatori,
            int etaMin) {

        Transaction transaction = null;

        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            NativeQuery<GiocoDaTavolo> s = session.createNativeQuery("UPDATE GiocoDaTavolo SET nome = :nome"
                    + " AND casa_produttrice = :casaProduttrice AND num_min_giocatori = :numMinGiocatori"
                    + " AND num_max_giocatori = :numMaxGiocatori AND eta_minima = :etaMinima"
                    + " WHERE id = :id", GiocoDaTavolo.class);

            s.setParameter("nome", nome);
            s.setParameter("casaProduttrice", casaProduttrice);
            s.setParameter("numMinGiocatori", numMinGiocatori);
            s.setParameter("numMaxGiocatori", numMaxGiocatori);
            s.setParameter("etaMin", etaMin);
            s.setParameter("id", id);
            s.executeUpdate();

            transaction.commit();

            session.close();

        } catch (ConstraintViolationException e) {

            System.out.println("Valore di chiave primaria duplicato per la tabella GiocoDaTavolo");
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
