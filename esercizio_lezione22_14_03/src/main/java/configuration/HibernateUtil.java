package configuration;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

//classe di configurazione che serve ad Hibernate per sapere quale file (hibernate.cfg.xml)
//continene tutte le configurazioni
public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {

        if (sessionFactory == null)
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
            
        return sessionFactory;

    }

}