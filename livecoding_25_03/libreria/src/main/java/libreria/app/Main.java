package libreria.app;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import libreria.configuration.Config;
import libreria.beans.Libreria;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("pre-apertura");
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		System.out.println("post-apertura");
		
		Libreria l1 = context.getBean("romanzo", Libreria.class);
		l1.setNome("Scaffale romanzi");
		System.out.println(l1);
		
		System.out.println("lavoro in corso");
		
		Libreria l2 = context.getBean("saggio", Libreria.class);
		l2.setNome("Scaffale saggi");
		System.out.println(l2);
		
		
		System.out.println("pre-chiusura");
		context.close();
		System.out.println("post-chiusura");
	}

}
