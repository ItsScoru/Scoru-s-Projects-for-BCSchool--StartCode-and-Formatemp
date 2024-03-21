package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Articolo {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codart")
	private int codart;

	@Column(name = "nome_descrizione")
	private String descrizione;

	@ManyToOne
	@JoinColumn(name = "id_famassort")
	private Famassort famassort;

	@ManyToOne
	@JoinColumn(name = "id_iva")
	private Iva iva;

	public Articolo(String descrizione) {
		super();
		this.descrizione = descrizione;
	}

	public Articolo(String descrizione, Famassort famassort, Iva iva) {
		super();
		this.descrizione = descrizione;
		this.famassort = famassort;
		this.iva = iva;
	}

	public Articolo() {
		super();
	}

	public int getCodart() {
		return codart;
	}

	public void setCodart(int codart) {
		this.codart = codart;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Famassort getFamassort() {
		return famassort;
	}

	public void setFamassort(Famassort famassort) {
		this.famassort = famassort;
	}

	public Iva getIva() {
		return iva;
	}

	public void setIva(Iva iva) {
		this.iva = iva;
	}

	@Override
	public String toString() {
		return "Articolo [codart=" + codart + ", descrizione=" + descrizione + "]";
	}

}
