package app.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Saggio {
	
private String nome;
	
	private final String tipo = "saggio";

	public Saggio() {
		super();
	}

	public Saggio(String nome) {
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
		return "Saggio [nome=" + nome + "]";
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("Bean saggio costruito");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("Bean saggio sta per essere distrutto");
	}

}
