package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Articolo {
	
	@Id
	@GeneratedValue
	private Integer codice;
	
	private Integer prezzo;
	
	private String nome;
	
	private String descrizione;
	
	private String categoria;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "ordini", joinColumns = @JoinColumn(name = "codice_articolo"),
		inverseJoinColumns = @JoinColumn(name = "id_ordine"))
	List<Ordine> listaOrdini;

	public Articolo() {
		super();
		setListaOrdini(new ArrayList<>());
	}

	public Articolo(Integer prezzo, String nome, String descrizione, String categoria) {
		super();
		setPrezzo(prezzo);
		setNome(nome);
		setDescrizione(descrizione);
		setCategoria(categoria);
		setListaOrdini(new ArrayList<>());
	}

	public Integer getCodice() {
		return codice;
	}

	public void setCodice(Integer codice) {
		this.codice = codice;
	}

	public Integer getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Integer prezzo) {
		this.prezzo = prezzo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public List<Ordine> getListaOrdini() {
		return listaOrdini;
	}

	public void setListaOrdini(List<Ordine> listaOrdini) {
		this.listaOrdini = listaOrdini;
	}

	@Override
	public String toString() {
		return "Articolo [codice=" + codice + ", prezzo=" + prezzo + ", nome=" + nome + ", descrizione=" + descrizione
				+ ", categoria=" + categoria + "]";
	}

}
