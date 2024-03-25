package app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import app.beans.Libreria;
import app.beans.Romanzo;
import app.beans.Saggio;
import app.configuration.Config;

public class Main {

	public static void main(String[] args) {

		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		Romanzo r1 = context.getBean(Romanzo.class);

		Saggio s1 = context.getBean(Saggio.class);

		Libreria l1 = context.getBean(Libreria.class);

		System.out.println("------------------------------");

		System.out.println(l1.vendiRomanzo());

		System.out.println("------------------------------");

		l1.setRomanzo(r1);

		System.out.println(l1.vendiRomanzo());

		System.out.println("------------------------------");

		l1.getRomanzo().setNome("I promessi sposi");

		System.out.println(l1.vendiRomanzo());

		System.out.println("------------------------------");

		s1.setNome("Aritmetica");

		l1.setSaggio(s1);

		System.out.println(l1.vendiSaggio());

		System.out.println("------------------------------");
		
		context.close();

	}

}
