package app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.beans.Utente;
import app.beans.UtentePlus;
import app.configuration.Config;

public class Main {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		Utente u = context.getBean(Utente.class);
		u.setNickname("Pippo");
		System.out.println(u.connettiti());
		
		UtentePlus up = context.getBean(UtentePlus.class);
		up.setNickname("Marco");
		System.out.println(up.connettiti());
		
		context.close();
		
	}

}
