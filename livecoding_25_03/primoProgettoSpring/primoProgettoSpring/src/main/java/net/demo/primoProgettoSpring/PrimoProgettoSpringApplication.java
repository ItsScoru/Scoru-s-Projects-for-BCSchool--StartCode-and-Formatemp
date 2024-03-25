package net.demo.primoProgettoSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import net.demo.primoProgettoSpring.model.Computer;

@SpringBootApplication
public class PrimoProgettoSpringApplication {

	public static void main(String[] args) {
		// SpringApplication.run(PrimoProgettoSpringApplication.class, args);
		// System.out.println("Ciao!");

		ApplicationContext context = SpringApplication.run(PrimoProgettoSpringApplication.class, args);

		Computer c = context.getBean(Computer.class);
		c.setModello("Acer 125AB23");
		c.getSchedaVideo().setMemoria(16);
		
		System.out.println(c.toString());
		
		
	}

}
