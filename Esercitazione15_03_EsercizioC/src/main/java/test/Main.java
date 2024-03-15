package test;

import java.util.ArrayList;

import dao.InterfacciaDao;
import dao.RichiestaFerieDaoImpl;
import entity.RichiestaFerie;

public class Main {

	public static void main(String[] args) {
		
		ArrayList<RichiestaFerie> listaRichieste = new ArrayList<>();
		
		listaRichieste.add(new RichiestaFerie(1, "2024-03-15", "2024-03-15", "businessfoglietta@gmail.com"
				, "2025-08-12", "2025-08-17", "Una qualsiasi", "In sospeso", "bho"));
		listaRichieste.add(new RichiestaFerie(2, "2024-03-15", "2024-03-15", "businessfoglietta@gmail.com"
				, "2025-08-12", "2025-08-17", "Una qualsiasi", "Rifiutata", "l'hai già fatta"));
		listaRichieste.add(new RichiestaFerie(3, "2024-03-15", "2024-03-15", "businessfoglietta@gmail.com"
				, "2025-08-12", "2025-08-17", "Una qualsiasi", "Rifiutata", "smettila!"));
		
		InterfacciaDao<RichiestaFerie> richiestaFerieDao1 = new RichiestaFerieDaoImpl();
		
		richiestaFerieDao1.insertMany(listaRichieste);
		
		System.out.println(richiestaFerieDao1.findAll());
		
	}

}
