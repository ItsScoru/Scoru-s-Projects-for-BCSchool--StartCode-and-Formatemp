package com.elezioni.demo.model;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity
public class Elettore implements Serializable{
	
	@Id
	private String codiceFiscale;

	private String nome;
	
	private String cognome;
	
	@Column(name = "codice_scheda")
	private Integer codiceScheda;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "scheda_elettorale")
	private Scheda scheda;
	
	private Seggio seggio;
	
	public Elettore() {
		super();
	}

	public Elettore(String codiceFiscale, String nome, String cognome, Integer codiceScheda) {
		super();
		setCodiceFiscale(codiceFiscale);
		setNome(cognome);
		setCognome(cognome);
		setCodiceScheda(codiceScheda);
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Scheda getScheda() {
		return scheda;
	}

	public void setScheda(Scheda scheda) {
		this.scheda = scheda;
	}

	public Integer getCodiceScheda() {
		return codiceScheda;
	}

	public void setCodiceScheda(Integer codiceScheda) {
		this.codiceScheda = codiceScheda;
	}

	public Seggio getSeggio() {
		return seggio;
	}

	public void setSeggio(Seggio seggio) {
		this.seggio = seggio;
	}

	@Override
	public String toString() {
		return "Elettore [codiceFiscale=" + codiceFiscale + ", nome=" + nome + ", cognome=" + cognome + ", scheda="
				+ scheda + "]";
	}
	
}
