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
import entity.Persona;

public class PersonaDaoImpl implements InterfacciaDao<Persona>{

    @Override
    public List<Persona> findAll() {

    	List<Persona> listaPersone = new ArrayList<>();

        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            listaPersone = session.createQuery("from Persona", Persona.class).list();

            session.close();

        } catch (HibernateException e) {

            System.out.println("Eccezione specifica di Hibernate durante la query");
            e.printStackTrace();

        } catch (Exception e) {

            System.out.println("Eccezione generica");
            e.printStackTrace();

        }

        return listaPersone;

    }

    @Override
    public Persona findOne(int id) {
        
        Persona persona = null;

        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Query<Persona> query = session.createQuery("from Persona where id = :id", Persona.class);
            query.setParameter("id", id);
            persona = query.getSingleResult();

            session.close();

        } catch (HibernateException e) {

            System.out.println("Eccezione specifica di Hibernate durante la query");
            e.printStackTrace();

        } catch (Exception e) {

            System.out.println("Eccezione generica");
            e.printStackTrace();

        }

        return persona;

    }

    @Override
    public void insertMany(List<Persona> listaPersone) {
        
        Transaction transaction = null;
        
        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            for (Persona persona : listaPersone) {
                session.save(persona);                
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
