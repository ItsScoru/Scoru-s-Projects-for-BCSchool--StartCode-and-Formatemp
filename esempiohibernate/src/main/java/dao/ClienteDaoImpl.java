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
import entity.Cliente;

public class ClienteDaoImpl implements InterfacciaDao<Cliente>{

    @Override
    public List<Cliente> findAll() {
        
        List<Cliente> listaClienti = new ArrayList<>();

        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            listaClienti = session.createQuery("from Cliente", Cliente.class).list();

            session.close();

        } catch (HibernateException e) {

            System.out.println("Eccezione specifica di Hibernate durante la query");
            e.printStackTrace();

        } catch (Exception e) {

            System.out.println("Eccezione generica");
            e.printStackTrace();

        }

        return listaClienti;

    }

    @Override
    public Cliente findOne(int id) {
        
        Cliente cliente = null;

        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Query<Cliente> query = session.createQuery("from Cliente where id = :id", Cliente.class);
            query.setParameter("id", id);
            cliente = query.getSingleResult();

            session.close();

        } catch (HibernateException e) {

            System.out.println("Eccezione specifica di Hibernate durante la query");
            e.printStackTrace();

        } catch (Exception e) {

            System.out.println("Eccezione generica");
            e.printStackTrace();

        }

        return cliente;

    }

    @Override
    public void insertMany(List<Cliente> listaClienti) {
        
        Transaction transaction = null;
        
        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            for (Cliente cliente : listaClienti) {
                session.save(cliente);                
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
