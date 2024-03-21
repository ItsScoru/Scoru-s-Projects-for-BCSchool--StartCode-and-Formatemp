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
public class Iva {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idiva")
	private int id;
	
	private String descrizione;
	
	@Column(name = "valore_aliquota")
	private String aliquota;

	@OneToMany
	@JoinColumn(name = "id_iva")
	private List<Articolo> articoli;
	
	
	public Iva() {
		super();
	}

	public Iva(String descrizione, String aliquota) {
		super();
		this.descrizione = descrizione;
		this.aliquota = aliquota;
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

	public String getAliquota() {
		return aliquota;
	}

	public void setAliquota(String aliquota) {
		this.aliquota = aliquota;
	}
	
	
	

	public List<Articolo> getArticoli() {
		return articoli;
	}

	public void setArticoli(List<Articolo> articoli) {
		this.articoli = articoli;
	}

	@Override
	public String toString() {
		return "Iva [id=" + id + ", descrizione=" + descrizione + ", aliquota=" + aliquota + "]";
	}
	
	
	

}
