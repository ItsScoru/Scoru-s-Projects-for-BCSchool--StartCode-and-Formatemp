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
import entity.Prenotazione;

public class PrenotazioneDaoImpl implements InterfacciaDao<Prenotazione>{

    @Override
    public List<Prenotazione> findAll() {
        
        List<Prenotazione> listaPrenotazioni = new ArrayList<>();

        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            listaPrenotazioni = session.createQuery("from Prenotazione", Prenotazione.class).list();

            session.close();

        } catch (HibernateException e) {

            System.out.println("Eccezione specifica di Hibernate durante la query");
            e.printStackTrace();

        } catch (Exception e) {

            System.out.println("Eccezione generica");
            e.printStackTrace();

        }

        return listaPrenotazioni;

    }

    @Override
    public Prenotazione findOne(int id) {
        
        Prenotazione prenotazione = null;

        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Query<Prenotazione> query = session.createQuery("from Prenotazione where id = :id", Prenotazione.class);
            query.setParameter("id", id);
            prenotazione = query.getSingleResult();

            session.close();

        } catch (HibernateException e) {

            System.out.println("Eccezione specifica di Hibernate durante la query");
            e.printStackTrace();

        } catch (Exception e) {

            System.out.println("Eccezione generica");
            e.printStackTrace();

        }

        return prenotazione;

    }

    @Override
    public void insertMany(List<Prenotazione> listaPrenotazioni) {
        
        Transaction transaction = null;
        
        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            for (Prenotazione prenotazione : listaPrenotazioni) {
                session.save(prenotazione);                
            }

            transaction.commit();

            session.close();

        } catch (ConstraintViolationException e) {

            System.out.println("Valore di chiave primaria duplicato per la tabella Autore");
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
