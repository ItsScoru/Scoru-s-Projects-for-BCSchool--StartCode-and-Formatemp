package entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Famassort {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_famassort")
	private int id;

	@Column
	private String descrizione;

	@OneToMany
	@JoinColumn(name ="id_famassort")
	private List<Articolo> articoli;
	
	
	public Famassort() {
		super();
	}

	public Famassort(String descrizione) {
		super();
		this.descrizione = descrizione;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	
	

	public List<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(List<Articolo> articoli) {
		this.articoli = articoli;
	}

	@Override
	public String toString() {
		return "Famassort [id=" + id + ", descrizione=" + descrizione + "]";
	}
	
	
	
}
