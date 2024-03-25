package app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.beans.Ordinazione;
import app.beans.Pizza;
import app.configuration.Config;

public class Main {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		Ordinazione o1 = context.getBean(Ordinazione.class);
		o1.setNome("Pippo");
		System.out.println(o1.ordine());
		
		Ordinazione o2 = context.getBean(Ordinazione.class);
		o2.setNome("Margherita");
		
		Pizza p1 = new Pizza("quattro formaggi");
		
		o2.setPizzaBianca(p1);
		System.out.println(o2.ordine());
		
		context.close();
		
	}

}
