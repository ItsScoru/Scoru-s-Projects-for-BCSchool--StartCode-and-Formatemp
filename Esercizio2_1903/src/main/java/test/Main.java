package test;

import dao.CittàDaoImpl;
import entity.Città;
import entity.Parco;

public class Main {
	
	public static void main(String[] args) {
		
		Città c1 = new Città("Milano", "Italia", 5);
		
		c1.getListaParchi().add(new Parco("Centrale", 4, 300, false, false, true, false, true, false, false));
		c1.getListaParchi().add(new Parco("Grosso", 8, 1000, true, false, true, false, true, true, true));
		c1.getListaParchi().add(new Parco("Comunale", 1, 70));
		
		CittàDaoImpl cittaDao = new CittàDaoImpl();
		
		cittaDao.findAll();
		
		cittaDao.insert(c1);
		
		cittaDao.findAll();
		
	}

}
