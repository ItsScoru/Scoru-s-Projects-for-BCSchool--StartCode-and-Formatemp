package test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.AcquirenteDaoImpl;
import dao.OrdineDaoImpl;
import entity.Acquirente;
import entity.Ordine;
import entity.Residenza;

public class Main {
	
	public static void main(String[] args) {
		
			Acquirente acquirente = new Acquirente();
			
			Residenza r = new Residenza("Via Roma", 12345, "Roma");
		
			List<Ordine> listaOrdini = new ArrayList<>();
			
			listaOrdini.add(new Ordine(1, new Date(2021, 7, 13), 70, 8, acquirente));
			listaOrdini.add(new Ordine(2, new Date(2022, 2, 9), 30, 1, acquirente));
			listaOrdini.add(new Ordine(3, new Date(2022, 11, 6), 7, 2, acquirente));
			listaOrdini.add(new Ordine(4, new Date(2023, 8, 25), 47, 3, acquirente));
			listaOrdini.add(new Ordine(5, new Date(2024, 2, 29), 52, 5, acquirente));
			
			acquirente.setCodiceFiscale("cdd3220nfj");
			acquirente.setNome("Pippo");
			acquirente.setCognome("Codice");
			acquirente.setTel("3333333333");
			acquirente.setResidenza(r);
			acquirente.setListaOrdini(listaOrdini);
			
			AcquirenteDaoImpl acquirenteDao = new AcquirenteDaoImpl();
			
			OrdineDaoImpl ordineDao = new OrdineDaoImpl();
			
			List<Acquirente> listaAcquirenti = new ArrayList<>();
			
			listaAcquirenti.add(acquirente);
			
			acquirenteDao.insertMany(listaAcquirenti);
			
			ordineDao.insertMany(listaOrdini);
		
	}

}
