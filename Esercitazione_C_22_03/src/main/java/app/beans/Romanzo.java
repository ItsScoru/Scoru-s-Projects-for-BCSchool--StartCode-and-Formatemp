package app.beans;

import javax.annotation.PostConstruct;

import jakarta.annotation.PreDestroy;

public class Romanzo {
	
	private String nome;
	
	private final String tipo = "romanzo";

	public Romanzo() {
		super();
	}

	public Romanzo(String nome) {
		super();
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTipo() {
		return tipo;
	}

	@Override
	public String toString() {
		return "Romanzo [nome=" + nome + "]";
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("Bean romanzo costruito");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("Bean romanzo sta per essere distrutto");
	}

}
