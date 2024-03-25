package app.beans;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import jakarta.annotation.PreDestroy;

public class Libreria {
	
	@Autowired
	private Romanzo romanzo;
	
	@Autowired
	private Saggio saggio;

	public String vendiRomanzo() {
		return this.romanzo + " è stato venduto";
	}
	
	public String vendiSaggio() {
		return this.saggio + " è stato venduto";
	}
	
	public Libreria() {
		super();
		this.romanzo = null;
		this.saggio = null;
	}

	public Libreria(Romanzo romanzo) {
		super();
		this.romanzo = romanzo;
		this.saggio = null;
	}

	public Libreria(Saggio saggio) {
		super();
		this.romanzo = null;
		this.saggio = saggio;
	}

	public Romanzo getRomanzo() {
		return romanzo;
	}

	public void setRomanzo(Romanzo romanzo) {
		this.romanzo = romanzo;
	}

	public Saggio getSaggio() {
		return saggio;
	}

	public void setSaggio(Saggio saggio) {
		this.saggio = saggio;
	}

	@PostConstruct
	public void postConstruct() {
		System.out.println("Bean libreria costruito");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("Bean libreria sta per essere distrutto");
	}

}
