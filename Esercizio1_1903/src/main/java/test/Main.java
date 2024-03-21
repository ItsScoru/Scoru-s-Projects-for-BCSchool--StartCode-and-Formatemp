package test;

import java.util.Date;

import dao.AcquirenteDaoImpl;
// import dao.OrdineDaoImpl;
import entity.Acquirente;
import entity.Ordine;
import entity.Residenza;

public class Main {

	public static void main(String[] args) {

		Acquirente acquirente = new Acquirente();

		Residenza r = new Residenza("Via Roma", 12345, "Roma");

		acquirente.getListaOrdini().add(new Ordine(new Date(2021, 7, 13), 70, 8));
		acquirente.getListaOrdini().add(new Ordine(new Date(2022, 2, 9), 30, 1));
		acquirente.getListaOrdini().add(new Ordine(new Date(2022, 11, 6), 7, 2));
		acquirente.getListaOrdini().add(new Ordine(new Date(2023, 8, 25), 47, 3));
		acquirente.getListaOrdini().add(new Ordine(new Date(2024, 2, 29), 52, 5));

		acquirente.setCodiceFiscale("cdd3220nfj");
		acquirente.setNome("Pippo");
		acquirente.setCognome("Codice");
		acquirente.setTel("3333333333");
		acquirente.setResidenza(r);

		AcquirenteDaoImpl acquirenteDao = new AcquirenteDaoImpl();

		// OrdineDaoImpl ordineDao = new OrdineDaoImpl();

		acquirenteDao.insert(acquirente);

		// for (Ordine x : acquirente.getListaOrdini()) {
		//		ordineDao.insert(x);
		// }

	}

}
