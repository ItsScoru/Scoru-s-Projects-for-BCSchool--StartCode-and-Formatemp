package libreria.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Libreria {

	private String nome;

	private Libro libro;

	public Libreria() {
		super();
	}

	public Libreria(Libro libro) {
		super();
		this.libro = libro;
	}

	public Libreria(String nome, Libro libro) {
		super();
		this.nome = nome;
		this.libro = libro;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	@Override
	public String toString() {
		return "Libreria [nome=" + nome + ", libro=" + libro + "]";
	}

	@PreDestroy
	public void metodoPreDestroy() {
		System.out.println("Bean Libreria sta per essere distrutto");
	}
	
	@PostConstruct
	public void metodoPostConstruct() {
		System.out.println("Bean libreria appena creato");
	}
}
