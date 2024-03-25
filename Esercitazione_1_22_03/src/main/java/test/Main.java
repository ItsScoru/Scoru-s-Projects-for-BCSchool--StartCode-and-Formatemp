package test;

import dao.NaveDaoImpl;
import entity.Capitano;
import entity.Nave;

public class Main {
	
	public static void main(String[] args) {
		
		Capitano c1 = new Capitano();
		c1.setNome("Pippo");
		c1.setCognome("Findus");
		Capitano c2 = new Capitano();
		c2.setNome("Nemo");
		c2.setCognome("Cook");
		Capitano c3 = new Capitano();
		c3.setNome("John");
		c3.setCognome("Schettino");
		
		Nave n1 = new Nave();
		n1.setNome("Poseidon");
		n1.setPropulsione("Vela");
		n1.setNumeroScialuppe(1);
		n1.setCapitano(c1);
		Nave n2 = new Nave();
		n2.setNome("Mariupol");
		n2.setPropulsione("Motore");
		n2.setNumeroScialuppe(4);
		n2.setCapitano(c2);
		Nave n3 = new Nave();
		n3.setNome("Costa Inventata");
		n3.setPropulsione("Motore");
		n3.setNumeroScialuppe(30);
		n3.setCapitano(c3);
		
		c1.setNave(n1);	
		c2.setNave(n2);	
		c3.setNave(n3);	
		
		NaveDaoImpl naveDao = new NaveDaoImpl();
		
		naveDao.save(n1);
		naveDao.save(n2);
		naveDao.save(n3);
		
	}

}
