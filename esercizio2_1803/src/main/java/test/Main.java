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
        
        List<Iva> listaIva = new ArrayList<>();

        listaIva.add(new Iva(0, "Bollo", 20.0));
        listaIva.add(new Iva(1, "Alimentare", 22.0));
        listaIva.add(new Iva(2, "Medica", 15.0));
        listaIva.add(new Iva(3, "Fiscale", 22.0));
        listaIva.add(new Iva(4, "Imposta", 5.0));

        IvaDaoImpl ivaDao = new IvaDaoImpl();

        ivaDao.insertMany(listaIva);

        List<Articolo> listaArticoli = new ArrayList<>();

        listaArticoli.add(new Articolo("1", "Pane"));
        listaArticoli.add(new Articolo("2", "Sapone"));
        listaArticoli.add(new Articolo("3", "Acqua"));
        listaArticoli.add(new Articolo("4", "Coperta"));
        listaArticoli.add(new Articolo("5", "Scarpe"));

        ArticoloDaoImpl articoloDao = new ArticoloDaoImpl();

        articoloDao.insertMany(listaArticoli);

        List<FamAssort> listAssort = new ArrayList<>();

        listAssort.add(new FamAssort(1, "Spesa1"));
        listAssort.add(new FamAssort(1, "Spesa2"));
        listAssort.add(new FamAssort(1, "Spesa3"));
        listAssort.add(new FamAssort(1, "Spesa4"));
        listAssort.add(new FamAssort(1, "Spesa5"));

        FamAssortDaoImpl famAssortDao = new FamAssortDaoImpl();

        famAssortDao.insertMany(listAssort);

        System.out.println(articoloDao.findAll());

        System.out.println("------------------------------------------------------------");

        System.out.println(ivaDao.findOne(3));

        System.out.println("-------------------------------------------------------------");

        System.out.println(famAssortDao.findAll());

    }
    
}