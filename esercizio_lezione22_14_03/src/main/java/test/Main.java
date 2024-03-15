package test;

import dao.AutomobileDaoImpl;
import dao.InterfacciaDao;
import dao.PersonaDaoImpl;
import entity.Automobile;
import entity.Persona;

public class Main {

    public static void main(String[] args) {
        
        InterfacciaDao<Automobile> autoDao = new AutomobileDaoImpl();
        
        System.out.println(autoDao.findAll());
        
        System.out.println("\n°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°°");
        
        InterfacciaDao<Persona> personaDao = new PersonaDaoImpl();
        
        System.out.println(personaDao.findAll());

    }
    
}
