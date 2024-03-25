package entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table
@SecondaryTable(name = "dettagli_partita", pkJoinColumns = @PrimaryKeyJoinColumn(name = "codice"))
public class Partita {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codice;
	
	@Column
	private String data;
	
	@Column(name = "cognome_arbitro", table = "dettagli_partita")
	private String cognomeArbitro;
	
	@Column(name = "nome_squadra_in_casa", table = "dettagli_partita")
	private String nomeSquadraCasa;
	
	@Column(name = "nome_squadra_sfidante", table = "dettagli_partita")
	private String nomeSquadraSfidante;
	
	@ManyToOne
	private Stadio stadio;

	public Partita() {
		super();
	}

	public Partita(String data) {
		super();
		this.data = data;
	}

	public Partita(String data, String cognomeArbitro, String nomeSquadraCasa, String nomeSquadraSfidante) {
		super();
		this.data = data;
		this.cognomeArbitro = cognomeArbitro;
		this.nomeSquadraCasa = nomeSquadraCasa;
		this.nomeSquadraSfidante = nomeSquadraSfidante;
	}

	public int getCodice() {
		return codice;
	}

	public void setCodice(int codice) {
		this.codice = codice;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getCognomeArbitro() {
		return cognomeArbitro;
	}

	public void setCognomeArbitro(String cognomeArbitro) {
		this.cognomeArbitro = cognomeArbitro;
	}

	public String getNomeSquadraCasa() {
		return nomeSquadraCasa;
	}

	public void setNomeSquadraCasa(String nomeSquadraCasa) {
		this.nomeSquadraCasa = nomeSquadraCasa;
	}

	public String getNomeSquadraSfidante() {
		return nomeSquadraSfidante;
	}

	public void setNomeSquadraSfidante(String nomeSquadraSfidante) {
		this.nomeSquadraSfidante = nomeSquadraSfidante;
	}

	public Stadio getStadio() {
		return stadio;
	}

	public void setStadio(Stadio stadio) {
		this.stadio = stadio;
	}

	@Override
	public String toString() {
		return "Partita [codice=" + codice + ", data=" + data + ", cognomeArbitro=" + cognomeArbitro
				+ ", nomeSquadraCasa=" + nomeSquadraCasa + ", nomeSquadraSfidante=" + nomeSquadraSfidante + "]";
	}

}
