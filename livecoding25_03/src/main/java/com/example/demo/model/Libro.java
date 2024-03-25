package com.example.demo.model;

import java.util.Objects;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Libro {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String titolo;
	
	 @Column(name = "id_autore")
	 @Nullable
	private Integer idAutore;
	 
	 @ManyToOne
	 @JoinColumn(name = "id_autore", insertable = false, updatable = false, nullable = true)
	 private Autore autore;

	public Libro() {
		super();
	}

	public Libro(Integer id, String titolo, Integer idAutore) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.idAutore = idAutore;
	}

	public Libro(Integer id, String titolo, Integer idAutore, Autore autore) {
		super();
		this.id = id;
		this.titolo = titolo;
		this.idAutore = idAutore;
		this.autore = autore;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}

	public Integer getIdAutore() {
		return idAutore;
	}

	public void setIdAutore(Integer idAutore) {
		this.idAutore = idAutore;
	}

	public Autore getAutore() {
		return autore;
	}

	public void setAutore(Autore autore) {
		this.autore = autore;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, idAutore, titolo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Libro other = (Libro) obj;
		return Objects.equals(id, other.id) && Objects.equals(idAutore, other.idAutore)
				&& Objects.equals(titolo, other.titolo);
	}

	@Override
	public String toString() {
		return "Libro [id=" + id + ", titolo=" + titolo + ", idAutore=" + idAutore + "]";
	}

}
