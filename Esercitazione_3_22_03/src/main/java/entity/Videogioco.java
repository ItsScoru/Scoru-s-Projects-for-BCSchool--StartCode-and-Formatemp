package entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table
@SecondaryTable(name = "dettagli_videogioco", pkJoinColumns =  @PrimaryKeyJoinColumn(name = "id"))
public class Videogioco {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column
	private String nome;
	
	@Column
	private int prezzo;
	
	@Column(table = "dettagli_videogioco")
	private String categoria;
	
	@Column(table = "dettagli_videogioco")
	private String descrizione;
	
	@Column
	private int pegi;
	
	@OneToMany(mappedBy = "videogioco", cascade = CascadeType.ALL)
	private List<Personaggio> personaggi;

	public Videogioco() {
		super();
		this.personaggi = new ArrayList<>();
	}

	public Videogioco(String nome, int prezzo, String categoria, String descrizione, int pegi) {
		super();
		this.nome = nome;
		this.prezzo = prezzo;
		this.categoria = categoria;
		this.descrizione = descrizione;
		this.pegi = pegi;
		this.personaggi = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(int prezzo) {
		this.prezzo = prezzo;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public int getPegi() {
		return pegi;
	}

	public void setPegi(int pegi) {
		this.pegi = pegi;
	}

	public List<Personaggio> getPersonaggi() {
		return personaggi;
	}

	public void setPersonaggi(List<Personaggio> personaggi) {
		this.personaggi = personaggi;
	}

	@Override
	public String toString() {
		return "Videogioco [id=" + id + ", nome=" + nome + ", prezzo=" + prezzo + ", categoria=" + categoria
				+ ", descrizione=" + descrizione + ", pegi=" + pegi + ", personaggi=" + personaggi + "]";
	}

}
