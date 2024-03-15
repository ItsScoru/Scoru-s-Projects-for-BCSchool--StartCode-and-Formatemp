package test;

import java.util.ArrayList;

import dao.CorsoDaoImpl;
import dao.InterfacciaDao;
import dao.MatricolaDaoImpl;
import dao.StudenteDaoImpl;
import entity.Corso;
import entity.Matricola;
import entity.Studente;

public class Main {
	
	public static void main(String[] args) {
		
		ArrayList<Corso> listaCorsi = new ArrayList<>();
		
		ArrayList<Matricola> listaMatricole = new ArrayList<>();
		
		ArrayList<Studente> listaStudenti = new ArrayList<>();
		
		listaCorsi.add(new Corso(1, "Filosofia", "Filosofia"));
		listaCorsi.add(new Corso(2, "Algebra", "Matematica"));
		listaCorsi.add(new Corso(3, "Lettere", "Inglese"));
		listaCorsi.add(new Corso(4, "Ingegneria", "Ingegneria Aerospaziale"));
		listaCorsi.add(new Corso(5, "Legge", "Legge"));
		
		listaMatricole.add(new Matricola(1, 1));
		listaMatricole.add(new Matricola(2, 2));
		listaMatricole.add(new Matricola(3, 3));
		listaMatricole.add(new Matricola(4, 4));
		listaMatricole.add(new Matricola(5, 5));
		
		listaStudenti.add(new Studente(1, "Mario", "Rossi", listaMatricole.get(0)));
		listaStudenti.add(new Studente(2, "Marco", "Bianchi",  listaMatricole.get(1)));
		listaStudenti.add(new Studente(3, "Claudio", "Neri",  listaMatricole.get(2)));
		listaStudenti.add(new Studente(4, "Filippo", "Verdi",  listaMatricole.get(3)));
		listaStudenti.add(new Studente(5, "Sergio", "Mattarella",  listaMatricole.get(4)));
		
		InterfacciaDao<Corso> corsoDao = new CorsoDaoImpl();
		
		InterfacciaDao<Matricola> matricolaDao = new MatricolaDaoImpl();
		
		InterfacciaDao<Studente> studenteDao = new StudenteDaoImpl();
		
		corsoDao.insertMany(listaCorsi);
		
		matricolaDao.insertMany(listaMatricole);
		
		studenteDao.insertMany(listaStudenti);
		
		System.out.println(corsoDao.findAll());
		
		System.out.println("--------------------------------------------------------");
		
		System.out.println(matricolaDao.findAll());
		
		System.out.println("--------------------------------------------------------");
		
		System.out.println(studenteDao.findAll());
		
	}

}
