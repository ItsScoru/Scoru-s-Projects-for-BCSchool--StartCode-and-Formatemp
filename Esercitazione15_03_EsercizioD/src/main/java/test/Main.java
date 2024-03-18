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
		
		ArrayList<Matricola> listaMatricole = new ArrayList<>();
		
		ArrayList<Corso> listaCorsi = new ArrayList<>();
		
		ArrayList<Studente> listaStudenti = new ArrayList<>();
		
		listaMatricole.add(new Matricola(1, "1"));
		listaMatricole.add(new Matricola(2, "2"));
		listaMatricole.add(new Matricola(3, "3"));
		listaMatricole.add(new Matricola(4, "4"));
		listaMatricole.add(new Matricola(5, "5"));
		
		listaCorsi.add(new Corso(1, "Filosofia", "Filosofia"));
		listaCorsi.add(new Corso(2, "Algebra", "Matematica"));
		listaCorsi.add(new Corso(3, "Lettere", "Inglese"));
		listaCorsi.add(new Corso(4, "Ingegneria", "Ingegneria Aerospaziale"));
		listaCorsi.add(new Corso(5, "Legge", "Legge"));
		
		InterfacciaDao<Matricola> matricolaDao = new MatricolaDaoImpl();
		matricolaDao.insertMany(listaMatricole);
		
		InterfacciaDao<Corso> corsoDao = new CorsoDaoImpl();
		corsoDao.insertMany(listaCorsi);
		
		listaStudenti.add(new Studente(1, "Mario", "Rossi", listaMatricole.get(0), listaCorsi));
		listaStudenti.add(new Studente(2, "Marco", "Bianchi", listaMatricole.get(1), listaCorsi));
		listaStudenti.add(new Studente(3, "Claudio", "Neri", listaMatricole.get(2), listaCorsi));
		listaStudenti.add(new Studente(4, "Filippo", "Verdi", listaMatricole.get(3), listaCorsi));
		listaStudenti.add(new Studente(5, "Sergio", "Mattarella", listaMatricole.get(4), listaCorsi));
		
		InterfacciaDao<Studente> studenteDao = new StudenteDaoImpl();
		studenteDao.insertMany(listaStudenti);

		Studente s = studenteDao.findOne(3);

		System.out.println(s);
		
		System.out.println(matricolaDao.findAll());

		corsoDao.update(4, "Arte");

		/*System.out.println(corsoDao.findAll());
		
		System.out.println("--------------------------------------------------------");
		
		System.out.println(matricolaDao.findAll());
		
		System.out.println("--------------------------------------------------------");
		
		System.out.println(studenteDao.findAll());*/
		
	}

}
