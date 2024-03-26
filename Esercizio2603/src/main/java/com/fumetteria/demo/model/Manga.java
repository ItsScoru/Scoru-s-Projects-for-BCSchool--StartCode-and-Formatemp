package com.fumetteria.demo.model;

import java.util.Objects;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Manga {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	private String titolo;
	
	@Column(name = "id_fumetteria")
	 @Nullable
	private Integer idFumetteria;
	
	@ManyToOne
	 @JoinColumn(name = "fumetteria")
	private Fumetteria fumetteria;

	public Manga() {
		super();
	}

	public Manga(Integer id, String titolo, Integer idFumetteria) {
		super();
		setId(id);
		setTitolo(titolo);
		setIdFumetteria(idFumetteria);
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

	public Integer getIdFumetteria() {
		return idFumetteria;
	}

	public void setIdFumetteria(Integer idFumetteria) {
		this.idFumetteria = idFumetteria;
	}

	public Fumetteria getFumetteria() {
		return fumetteria;
	}

	public void setFumetteria(Fumetteria fumetteria) {
		this.fumetteria = fumetteria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(fumetteria, id, titolo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Manga other = (Manga) obj;
		return Objects.equals(fumetteria, other.fumetteria) && Objects.equals(id, other.id)
				&& Objects.equals(titolo, other.titolo);
	}

	@Override
	public String toString() {
		return "Manga [id=" + id + ", titolo=" + titolo + ", fumetteria=" + fumetteria + "]";
	}

}
