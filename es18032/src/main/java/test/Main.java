package test;

import entity.Articolo;
import entity.Famassort;
import entity.Iva;

import dao.OggettoDao;

public class Main {
	
	public static void main(String[] args) {
		
		OggettoDao oggettoDao = new OggettoDao();
		
		Articolo a1 = new Articolo("Aranciata");
		Articolo a2 = new Articolo("Acqua");
		Articolo a3 = new Articolo("Coca cola");
		Articolo a4 = new Articolo("Miele");
		Articolo a5 = new Articolo("Sapone");
		
		
		Famassort f1 = new Famassort("Bevanda");
		Famassort f2 = new Famassort("Cosmetica");
		Famassort f3 = new Famassort("Casa");
		Famassort f4 = new Famassort("Hobby");
		Famassort f5 = new Famassort("Cibo");
		
		Iva i1 = new Iva("iva1", "4");
		Iva i2 = new Iva("iva2", "14");
		Iva i3 = new Iva("iva3", "24");
		Iva i4 = new Iva("iva4", "22");
		Iva i5 = new Iva("iva5", "50");
		
		
		
		oggettoDao.salvaOggetto(i1);
		oggettoDao.salvaOggetto(i2);
		oggettoDao.salvaOggetto(i3);
		oggettoDao.salvaOggetto(i4);
		oggettoDao.salvaOggetto(i5);
		
		
		oggettoDao.salvaOggetto(f1);
		oggettoDao.salvaOggetto(f2);
		oggettoDao.salvaOggetto(f3);
		oggettoDao.salvaOggetto(f4);
		oggettoDao.salvaOggetto(f5);
		
		
		
		a1.setFamassort(f1);
		a2.setFamassort(f1);
		a3.setFamassort(f1);
		a4.setFamassort(f5);
		a5.setFamassort(f2);
		
		
		a1.setIva(i4);
		a2.setIva(i3);
		a3.setIva(i2);
		a4.setIva(i1);
		a5.setIva(i5);
		
		
		
		
		oggettoDao.salvaOggetto(a1);
		oggettoDao.salvaOggetto(a2);
		oggettoDao.salvaOggetto(a3);
		oggettoDao.salvaOggetto(a4);
		oggettoDao.salvaOggetto(a5);
		
		
		
		
		
		
		
	}

}
