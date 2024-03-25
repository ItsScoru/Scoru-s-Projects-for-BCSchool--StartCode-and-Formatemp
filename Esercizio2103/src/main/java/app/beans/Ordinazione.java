package app.beans;

import javax.annotation.Resource;

public class Ordinazione {
	
	private String nome;
	
	private Pizza pizza;
	
	public Ordinazione() {
		super();
	}
	
	public Ordinazione(int numOrdinazione, String nome, Pizza pizza) {
		this.nome = nome;
		this.pizza = pizza;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Pizza getPizza() {
		return pizza;
	}
	
	@Resource(name = "rossa")
	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

	@Resource(name = "bianca")
	public void setPizzaBianca(Pizza pizza) {
		this.pizza = pizza;
	}
	
	public String ordine() {
		return this.nome + " " + this.pizza.mangia();
	}

}
