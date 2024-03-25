package test;

import dao.StadioDaoImpl;
import entity.Partita;
import entity.Stadio;
import entity.Ubicazione;

public class Main {
	
	public static void main(String[] args) {
		
		Ubicazione u1 = new Ubicazione("Via Roma", "Roma", 00001);
		
		Stadio s1 = new Stadio("Colossus", 50000, "Olimpico");
		
		s1.setUbicazione(u1);
		
		Partita p1 = new Partita("01/01/2000", "Arbitrini", "Roma", "Milan");
		Partita p2 = new Partita("23/08/2004", "Palloni", "Roma", "Fiorentina");
		Partita p3 = new Partita("11/06/2008", "Fisicato", "Roma", "Chieti");
		
		s1.getPartite().add(p1);
		s1.getPartite().add(p2);
		s1.getPartite().add(p3);
		
		p1.setStadio(s1);
		p2.setStadio(s1);
		p3.setStadio(s1);
		
		StadioDaoImpl stadioDao = new StadioDaoImpl();
		
		stadioDao.save(s1);
		
	}

}
