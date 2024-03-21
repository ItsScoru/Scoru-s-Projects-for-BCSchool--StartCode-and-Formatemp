package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import configuration.HibernateUtil;

public class OggettoDao {
	
	
	public void salvaOggetto(Object oggetto) {
		
		
		Transaction transaction = null;
		
		try{
			Session session= HibernateUtil.getSessionFactory().openSession();
			
			transaction = session.beginTransaction();
			
			session.save(oggetto);
			
			transaction.commit();
		}catch(Exception e) {
			transaction.rollback();
		}
		
		
	}

}
