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
import javax.persistence.Table;

@Entity
@Table
public class Città {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codice;
	
	@Column
	private String nome;
	
	@Column
	private String stato;
	
	@Column(name = "numero_abitanti")
	private int numeroAbitanti;
	
	@OneToMany(mappedBy = "città", cascade = CascadeType.ALL)
	private List<Parco> listaParchi;

	public Città() {
		super();
		this.listaParchi = new ArrayList<>();
	}

	public Città(int codice, String nome, String stato, int numeroAbitanti, List<Parco> listaParchi) {
		super();
		this.codice = codice;
		this.nome = nome;
		this.stato = stato;
		this.numeroAbitanti = numeroAbitanti;
		this.listaParchi = listaParchi;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public int getNumeroAbitanti() {
		return numeroAbitanti;
	}

	public void setNumeroAbitanti(int numeroAbitanti) {
		this.numeroAbitanti = numeroAbitanti;
	}

	public List<Parco> getListaParchi() {
		return listaParchi;
	}

	public void setListaParchi(List<Parco> listaParchi) {
		this.listaParchi = listaParchi;
	}

	@Override
	public String toString() {
		return "Città [codice=" + codice + ", nome=" + nome + ", stato=" + stato + ", numeroAbitanti=" + numeroAbitanti
				+ "]";
	}

}
