package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
	@JoinColumn(name = "id_matricola")
	private Matricola matricola;

	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "corso_studente", joinColumns = @JoinColumn(name = "id_corso", referencedColumnName = "Id"),
	inverseJoinColumns = @JoinColumn(name = "id_studente", referencedColumnName = "Id"))
	private List<Corso> listaCorsi;

	public Studente() {
		super();
	}

	public Studente(Integer id, String nome, String cognome) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
	}

	public Studente(Integer id, String nome, String cognome, Matricola matricola, List<Corso> listaCorsi) {
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
		this.listaCorsi = listaCorsi;
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

	public List<Corso> getListaCorsi() {
		return listaCorsi;
	}

	public void setListaCorsi(List<Corso> listaCorsi) {
		this.listaCorsi = listaCorsi;
	}

	@Override
	public String toString() {
		return "Studente [id=" + id + ", nome=" + nome + ", cognome=" + cognome + "]";
	}

}
