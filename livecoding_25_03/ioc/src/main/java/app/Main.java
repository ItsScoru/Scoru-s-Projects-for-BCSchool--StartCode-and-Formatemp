package app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.beans.Utente;
import app.beans.Connessione;
import app.beans.UtentePlus;
import app.configuration.Config;


public class Main {
	
	public static void main(String[] args) {
		
		
//		Utente u = new Utente();
//		u.setNickname("renato");
//		
//		Connessione c = new Connessione();
//		u.setConnessione(c);
//		
//		System.out.println(u.connettiti());
		
		System.out.println("Pre-start");
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		System.out.println("Post-start");
		
		System.out.println("lavori in corso");
		
		Utente u1 = context.getBean(Utente.class);
		//u1.setNickname("Leone");
		System.out.println(u1.connettiti());
		
		UtentePlus u2 = context.getBean(UtentePlus.class);
		//u2.setNickname("Elia");
		System.out.println(u2.connettiti());
		
		
	//	System.out.println(context.getBean(Utente.class).connettiti());
		
		context.close();
		
		System.out.println("context ormai chiuso");
	}

}
