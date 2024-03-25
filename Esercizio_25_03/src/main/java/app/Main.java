package app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.beans.Automobile;
import app.beans.Motore;
import app.configuration.Config;

public class Main {
	
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		Automobile a1 = context.getBean("auto_benzina", Automobile.class);
		
		Automobile a2 = context.getBean("auto_elettrica", Automobile.class);
		
		Automobile a3 = context.getBean("auto_ibrida", Automobile.class);
		
		//non ho ancora capito come scrivere questo sia più lento e complicato
		Automobile a4 = new Automobile("Subaru", new Motore("Benzina"));
		
		a1.setMarca("Fiat");
		a2.setMarca("Toyota");
		a3.setMarca("Renault");
		
		System.out.println(a1);
		System.out.println(a2);
		System.out.println(a3);
		System.out.println(a4);
		
		context.close();
		
	}
	
}
