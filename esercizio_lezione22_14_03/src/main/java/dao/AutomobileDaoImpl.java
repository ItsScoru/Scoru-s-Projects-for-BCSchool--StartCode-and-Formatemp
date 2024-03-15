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
import entity.Automobile;

public class AutomobileDaoImpl implements InterfacciaDao<Automobile>{

    @Override
    public List<Automobile> findAll() {
        
        List<Automobile> listaAutomobili = new ArrayList<>();

        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            listaAutomobili = session.createQuery("from Automobile", Automobile.class).list();

            session.close();

        } catch (HibernateException e) {

            System.out.println("Eccezione specifica di Hibernate durante la query");
            e.printStackTrace();

        } catch (Exception e) {

            System.out.println("Eccezione generica");
            e.printStackTrace();

        }

        return listaAutomobili;

    }

    @Override
    public Automobile findOne(int id) {
        
        Automobile automobile = null;

        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Query<Automobile> query = session.createQuery("from Automobile where id = :id", Automobile.class);
            query.setParameter("id", id);
            automobile = query.getSingleResult();

            session.close();

        } catch (HibernateException e) {

            System.out.println("Eccezione specifica di Hibernate durante la query");
            e.printStackTrace();

        } catch (Exception e) {

            System.out.println("Eccezione generica");
            e.printStackTrace();

        }

        return automobile;
    
    }

    @Override
    public void insertMany(List<Automobile> listaAutomobili) {
        
        Transaction transaction = null;
        
        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            for (Automobile autommobile : listaAutomobili) {
                session.save(autommobile);                
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
