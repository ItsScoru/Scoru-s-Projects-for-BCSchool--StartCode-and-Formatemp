package com.fumetteria.demo.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Fumetteria {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String nome;
	
	@OneToMany(mappedBy = "fumetteria")
	private List<Manga> listaManga;

	public Fumetteria() {
		super();
		setListaManga(new ArrayList<>());
	}

	public Fumetteria(Integer id, String nome) {
		super();
		setId(id);
		setNome(nome);
		setListaManga(new ArrayList<>());
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

	public List<Manga> getListaManga() {
		return listaManga;
	}

	public void setListaManga(List<Manga> listaManga) {
		this.listaManga = listaManga;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, listaManga, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fumetteria other = (Fumetteria) obj;
		return Objects.equals(id, other.id) && Objects.equals(listaManga, other.listaManga)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Fumetteria [id=" + id + ", nome=" + nome + "]";
	}

}
