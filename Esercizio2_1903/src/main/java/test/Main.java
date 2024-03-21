package test;

import java.util.ArrayList;
import java.util.List;

import dao.CittàDaoImpl;
import entity.Città;
import entity.Parco;

public class Main {
	
	public static void main(String[] args) {
		
		Città c1 = new Città(1, "Milano", "Italia", 5, null);
		
		Parco p1 = new Parco(1, "Centrale", 4, 300, false, false, true, false, true, false, false, c1);
		Parco p2 = new Parco(2, "Grosso", 8, 1000, true, false, true, false, true, true, true, c1);
		Parco p3 = new Parco(3, "Comunale", 1, 70);
		
		p3.setCittà(c1);
		
		List<Parco> listaParchi = new ArrayList<>();
		
		listaParchi.add(p1);
		listaParchi.add(p2);
		listaParchi.add(p3);
		
		c1.setListaParchi(listaParchi);
		
		CittàDaoImpl cittaDao = new CittàDaoImpl();
		
		cittaDao.findAll();
		
	}

}
