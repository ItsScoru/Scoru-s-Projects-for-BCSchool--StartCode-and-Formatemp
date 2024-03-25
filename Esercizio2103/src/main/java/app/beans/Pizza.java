package app.beans;

import javax.annotation.PostConstruct;

public  class Pizza {
	
	private String tipo;
	
	public Pizza() {
		this.tipo = "margherita";
	}
	
	public Pizza(String tipo) {
		this.tipo = tipo;
	}
	
	@PostConstruct
	public void metodoPostConstructor() {
		System.out.println("La pizza è in forno");
	}
	
	public String mangia() {
		return "sta mangiando una pizza " + this.tipo;
	}

}