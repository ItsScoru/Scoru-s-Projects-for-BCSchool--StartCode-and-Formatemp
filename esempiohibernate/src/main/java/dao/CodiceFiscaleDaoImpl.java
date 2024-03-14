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
import entity.CodiceFiscale;

public class CodiceFiscaleDaoImpl implements InterfacciaDao<CodiceFiscale>{

    @Override
    public List<CodiceFiscale> findAll() {

        List<CodiceFiscale> listaCF = new ArrayList<>();

        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            listaCF = session.createQuery("from Codice_fiscale", CodiceFiscale.class).list();

            session.close();

        } catch (HibernateException e) {

            System.out.println("Eccezione specifica di Hibernate durante la query");
            e.printStackTrace();

        } catch (Exception e) {

            System.out.println("Eccezione generica");
            e.printStackTrace();

        }

        return listaCF;
    }

    @Override
    public CodiceFiscale findOne(int id) {
        
        CodiceFiscale CodFis = null;

        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            Query<CodiceFiscale> query = session.createQuery("from Codice_fiscale where id = :id", CodiceFiscale.class);
            query.setParameter("id", id);
            CodFis = query.getSingleResult();

            session.close();

        } catch (HibernateException e) {

            System.out.println("Eccezione specifica di Hibernate durante la query");
            e.printStackTrace();

        } catch (Exception e) {

            System.out.println("Eccezione generica");
            e.printStackTrace();

        }

        return CodFis;

    }

    @Override
    public void insertMany(List<CodiceFiscale> listaCodiciFiscali) {

        Transaction transaction = null;
        
        try {

            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            Session session = sessionFactory.openSession();

            transaction = session.beginTransaction();

            for (CodiceFiscale cf : listaCodiciFiscali) {
                session.save(cf);                
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
