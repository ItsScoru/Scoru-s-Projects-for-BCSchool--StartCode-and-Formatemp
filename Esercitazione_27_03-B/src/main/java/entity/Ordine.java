package entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Ordine {
	
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(name = "data_richiesta")
	@Temporal(TemporalType.DATE)
	private Date dataRichiesta;
	
	@Column(name = "prezzo_totale")
	private Integer prezzoTotale;
	
	@Column(name = "numero_articoli")
	private Integer numeroArticoli;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "articoli", joinColumns = @JoinColumn(name = "codice_articolo"),
		inverseJoinColumns = @JoinColumn(name = "id_ordine"))
	List<Articolo> listaArticoli;

	public Ordine() {
		super();
		setListaArticoli(new ArrayList<>());
	}

	public Ordine(Date dataRichiesta, Integer prezzoTotale, Integer numeroArticoli) {
		super();
		setDataRichiesta(dataRichiesta);
		setPrezzoTotale(prezzoTotale);
		setNumeroArticoli(numeroArticoli);
		setListaArticoli(new ArrayList<>());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataRichiesta() {
		return dataRichiesta;
	}

	public void setDataRichiesta(Date dataRichiesta) {
		this.dataRichiesta = dataRichiesta;
	}

	public Integer getPrezzoTotale() {
		return prezzoTotale;
	}

	public void setPrezzoTotale(Integer prezzoTotale) {
		this.prezzoTotale = prezzoTotale;
	}

	public Integer getNumeroArticoli() {
		return numeroArticoli;
	}

	public void setNumeroArticoli(Integer numeroArticoli) {
		this.numeroArticoli = numeroArticoli;
	}

	public List<Articolo> getListaArticoli() {
		return listaArticoli;
	}

	public void setListaArticoli(List<Articolo> listaArticoli) {
		this.listaArticoli = listaArticoli;
	}

	@Override
	public String toString() {
		return "Ordine [id=" + id + ", dataRichiesta=" + dataRichiesta + ", prezzoTotale=" + prezzoTotale
				+ ", numeroArticoli=" + numeroArticoli + "]";
	}

}
