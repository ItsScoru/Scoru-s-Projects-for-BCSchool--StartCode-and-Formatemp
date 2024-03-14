package test;

import dao.AutoreDaoImpl;
import dao.ClienteDaoImpl;
import dao.CodiceFiscaleDaoImpl;
import dao.InterfacciaDao;
import dao.LibroDaoImpl;
import dao.PrenotazioneDaoImpl;
import entity.Autore;
import entity.Cliente;
import entity.CodiceFiscale;
import entity.Libro;
import entity.Prenotazione;

public class Main {

    public static void main(String[] args) {
        
        InterfacciaDao<Autore> autoreDao = new AutoreDaoImpl();
        
        System.out.println(autoreDao.findAll());

        System.out.println("------------------------------");

        InterfacciaDao<Libro> libroDao = new LibroDaoImpl();

        System.out.println(libroDao.findAll());

        System.out.println("------------------------------");

        InterfacciaDao<Cliente> clienteDao = new ClienteDaoImpl();

        System.out.println(clienteDao.findAll());

        System.out.println("------------------------------");

        InterfacciaDao<CodiceFiscale> codiceFiscaleDao = new CodiceFiscaleDaoImpl();

        System.out.println(codiceFiscaleDao.findAll());

        System.out.println("------------------------------");

        InterfacciaDao<Prenotazione> prenotazioneDao = new PrenotazioneDaoImpl();

        System.out.println(prenotazioneDao.findAll());

        System.out.println("------------------------------");

    }
    
}
