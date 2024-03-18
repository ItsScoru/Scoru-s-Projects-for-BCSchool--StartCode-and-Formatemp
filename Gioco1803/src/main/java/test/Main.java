package test;

import java.util.ArrayList;
import java.util.List;

import dao.GiocoDaTavoloDaoImpl;
import dao.PartecipanteDaoImpl;
import entity.GiocoDaTavolo;
import entity.Partecipante;

public class Main {

    public static void main(String[] args) {
        
        List<GiocoDaTavolo> listaGiochi = new ArrayList<>();

        listaGiochi.add(new GiocoDaTavolo("Monopoli", "Hasbro", 3, 6, 8));
        listaGiochi.add(new GiocoDaTavolo("Risiko", "Hasbro", 4, 6, 12));
        listaGiochi.add(new GiocoDaTavolo("Perudo", "Asmodee", 4, 12, 12));
        listaGiochi.add(new GiocoDaTavolo("Zombicide", "Guillotine games", 1, 6, 12));
        listaGiochi.add(new GiocoDaTavolo("Uno", "Mattel", 2, 8, 6));

        GiocoDaTavoloDaoImpl ttgDao = new GiocoDaTavoloDaoImpl();

        ttgDao.insertMany(listaGiochi);

        List<Partecipante> listaGiocatori = new ArrayList<>();

        listaGiocatori.add(new Partecipante(1, "Marco", "Rossi", 52, listaGiochi.get(4)));
        listaGiocatori.add(new Partecipante(2, "Marco", "Bianchi", 7, listaGiochi.get(4)));
        listaGiocatori.add(new Partecipante(3, "Giulia", "Verdi", 48, listaGiochi.get(1)));
        listaGiocatori.add(new Partecipante(4, "Filippo", "Neri", 16, listaGiochi.get(0)));
        listaGiocatori.add(new Partecipante(5, "Celeste", "Rizzo", 5, listaGiochi.get(2)));
        listaGiocatori.add(new Partecipante(6, "Gabriele", "Di Gesù", 33, listaGiochi.get(1)));
        listaGiocatori.add(new Partecipante(7, "Antonio", "Piazza", 22, listaGiochi.get(3)));
        listaGiocatori.add(new Partecipante(8, "Angelo", "Bonomo", 9, listaGiochi.get(3)));
        listaGiocatori.add(new Partecipante(9, "Giovanni", "Giorno", 11, listaGiochi.get(0)));
        listaGiocatori.add(new Partecipante(10, "Manfredi", "Arca", 40, listaGiochi.get(2)));

        PartecipanteDaoImpl partecipanteDao = new PartecipanteDaoImpl();

        partecipanteDao.insertMany(listaGiocatori);

        System.out.println(partecipanteDao.findAll());

        System.out.println("--------------------------------");

        System.out.println(ttgDao.findOne("Uno"));

    }
    
}
