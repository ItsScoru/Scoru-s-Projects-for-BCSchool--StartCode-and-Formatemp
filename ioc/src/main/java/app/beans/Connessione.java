package app.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Connessione {
	
	private String tipo;
	
	public Connessione() {
		this.tipo = "base";
	}
	
	public Connessione(String tipo) {
		this.tipo = tipo;
	}
	
	@PostConstruct
	public void metodoPostConstructor() {
		System.out.println("Bean connessione appena creato");
	}
	
	@PreDestroy
	public void metodoPreDestroy() {
		System.out.println("Bean connessione  sta per essere distrutto");
	}
	
	public String 	login() {
		return "si sta connettendo in maniera " + this.tipo;
	}

}
