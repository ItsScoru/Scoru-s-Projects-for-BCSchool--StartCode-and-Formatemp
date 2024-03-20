package test;

import java.util.ArrayList;
import java.util.List;

import dao.ArticoloDaoImpl;
import dao.FamAssortDaoImpl;
import dao.IvaDaoImpl;
import entity.Articolo;
import entity.FamAssort;
import entity.Iva;

public class Main {

	public static void main(String[] args) {

		List<FamAssort> listAssort = new ArrayList<>();
		List<Iva> listaIva = new ArrayList<>();
		List<Articolo> listaArticoli = new ArrayList<>();

		listaIva.add(new Iva(0, "Bollo", 20.0));
		listaIva.add(new Iva(1, "Alimentare", 22.0));
		listaIva.add(new Iva(2, "Medica", 15.0));
		listaIva.add(new Iva(3, "Fiscale", 22.0));
		listaIva.add(new Iva(4, "Imposta", 5.0));

		listAssort.add(new FamAssort(1, "Spesa1"));
		listAssort.add(new FamAssort(1, "Spesa2"));
		listAssort.add(new FamAssort(1, "Spesa3"));
		listAssort.add(new FamAssort(1, "Spesa4"));
		listAssort.add(new FamAssort(1, "Spesa5"));
		
		listaArticoli.add(new Articolo(1, "Pane", listAssort.get(0), listaIva.get(0)));
		listaArticoli.add(new Articolo(2, "Sapone", listAssort.get(1), listaIva.get(1)));
		listaArticoli.add(new Articolo(3, "Acqua", listAssort.get(2), listaIva.get(2)));
		listaArticoli.add(new Articolo(4, "Coperta", listAssort.get(3), listaIva.get(3)));
		listaArticoli.add(new Articolo(5, "Scarpe", listAssort.get(4), listaIva.get(4)));
		
		listaIva.get(0).setListaArticoli(listaArticoli);
		listaIva.get(1).setListaArticoli(listaArticoli);
		listaIva.get(2).setListaArticoli(listaArticoli);
		listaIva.get(3).setListaArticoli(listaArticoli);
		listaIva.get(4).setListaArticoli(listaArticoli);
		
		listAssort.get(0).setListaArticoli(listaArticoli);
		listAssort.get(1).setListaArticoli(listaArticoli);
		listAssort.get(2).setListaArticoli(listaArticoli);
		listAssort.get(3).setListaArticoli(listaArticoli);
		listAssort.get(4).setListaArticoli(listaArticoli);

		IvaDaoImpl ivaDao = new IvaDaoImpl();

		FamAssortDaoImpl famAssortDao = new FamAssortDaoImpl();

		ArticoloDaoImpl articoloDao = new ArticoloDaoImpl();

		famAssortDao.insertMany(listAssort);

		articoloDao.insertMany(listaArticoli);
		
		ivaDao.insertMany(listaIva);

		
		/*System.out.println(articoloDao.findAll());

		System.out.println("------------------------------------------------------------");

		System.out.println(ivaDao.findOne(3));

		System.out.println("-------------------------------------------------------------");

		System.out.println(famAssortDao.findAll());*/

	}

}