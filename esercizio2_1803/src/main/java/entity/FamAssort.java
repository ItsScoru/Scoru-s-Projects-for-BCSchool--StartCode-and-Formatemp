package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
public class FamAssort {

	@Id
	@Column(name = "id_famassort")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column
	private String descrizione;

	@OneToMany
	@JoinColumn(name = "id_famassort")
	private List<Articolo> listaArticoli;

	public FamAssort() {
		super();
	}

	public FamAssort(int id, String descrizione) {
		this.id = id;
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

	public List<Articolo> getListaArticoli() {
		return listaArticoli;
	}

	public void setListaArticoli(List<Articolo> listaArticoli) {
		this.listaArticoli = listaArticoli;
	}
	
	//addArticoloToLista

	@Override
	public String toString() {
		return "FamAssort [id=" + id + ", descrizione=" + descrizione + ", listaArticoli=" + listaArticoli + "]";
	}

}
