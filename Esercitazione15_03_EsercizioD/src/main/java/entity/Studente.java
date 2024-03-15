package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
public class Studente {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column
	private String nome;
	
	@Column
	private String cognome;
	
	@OneToOne
	@JoinColumn(name = "matricola")
	private Matricola matricola;

	public Studente() {
		super();
	}

	public Studente(Integer id, String nome, String cognome, Matricola matricola) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Matricola getMatricola() {
		return matricola;
	}

	public void setMatricola(Matricola matricola) {
		this.matricola = matricola;
	}
	@Override
	public String toString() {
		return "Studente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + ", matricola=" + matricola
				+ "]";
	}

}
