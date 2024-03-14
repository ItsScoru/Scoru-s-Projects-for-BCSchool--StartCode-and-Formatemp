package test;

import dao.AutoreDaoImpl;
import dao.InterfacciaDao;
import dao.LibroDaoImpl;
import entity.Autore;
import entity.Libro;

public class Main {

    public static void main(String[] args) {
        
        InterfacciaDao<Autore> autoreDao = new AutoreDaoImpl();
        
        System.out.println(autoreDao.findAll());

        InterfacciaDao<Libro> libroDao = new LibroDaoImpl();

        System.out.println(libroDao.findAll());

    }
    
}
