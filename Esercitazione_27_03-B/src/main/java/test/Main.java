package test;

import java.util.Date;

import dao.OrdineDaoImpl;
import entity.Articolo;
import entity.Ordine;

public class Main {
	
	public static void main(String[] args) {
		
		Articolo a1 = new Articolo(12, "Piatto", "Piatto di porcellana", "Cucina");
		Articolo a2 = new Articolo(8, "Pallone", "Pallone da calcio", "Sport");
		Articolo a3 = new Articolo(15, "CD", "Album Britney Spears", "Musica");
		
		Ordine o1 = new Ordine(new Date(123, 10, 22), 35, 3);
		
		o1.getListaArticoli().add(a1);
		o1.getListaArticoli().add(a2);
		o1.getListaArticoli().add(a3);
		
		OrdineDaoImpl ordineDao = new OrdineDaoImpl();
		
		ordineDao.insertOne(o1);
		
	}

}
