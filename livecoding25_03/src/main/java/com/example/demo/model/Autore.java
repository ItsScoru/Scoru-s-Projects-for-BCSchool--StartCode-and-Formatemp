package com.example.demo.model;

import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Autore {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;
	
	private String cognome;
	
	@OneToMany(mappedBy = "autore")
	private List<Libro> listaLibri;

	public Autore() {
		super();
	}

	public Autore(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
	}

	public Autore(Integer id, String nome, String cognome) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
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

	public List<Libro> getListaLibri() {
		return listaLibri;
	}

	public void setListaLibri(List<Libro> listaLibri) {
		this.listaLibri = listaLibri;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cognome, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autore other = (Autore) obj;
		return Objects.equals(cognome, other.cognome) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Autore [id=" + id + ", nome=" + nome + ", cognome=" + cognome + "]";
	}

}
