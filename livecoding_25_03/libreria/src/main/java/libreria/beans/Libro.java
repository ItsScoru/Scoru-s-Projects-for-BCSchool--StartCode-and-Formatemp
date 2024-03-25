package libreria.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Libro {
	
	
	private String tipologia; //saggio o romanzo
	
	public Libro() {
		
	}
	
	public Libro(String tipologia) {
		this.tipologia = tipologia;
	}

	public String getTipologia() {
		return tipologia;
	}

	public void setTipologia(String tipologia) {
		this.tipologia = tipologia;
	}

	@Override
	public String toString() {
		return "Libro [tipologia=" + tipologia + "]";
	}
	
	@PostConstruct
	public void metodoPostConstruct() {
		System.out.println("Bean libro appena creato");
	}
	
	@PreDestroy
	public void metodoPreDestroy() {
		System.out.println("Bean libro sta per essere ditsrutto");
	}

}
