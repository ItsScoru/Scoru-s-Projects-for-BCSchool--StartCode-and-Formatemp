package com.elezioni.demo.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Scheda implements Serializable{
	
	@Id
	private Integer codice;
	
	@Temporal(TemporalType.DATE)
	private Date scadenza;
	
	private Elettore elettore;
	
	@Column(name = "codice_seggio")
	private Integer codiceSeggio;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "seggio")
	private Seggio seggio;

	public Scheda() {
		super();
	}

	public Scheda(Integer codice, Date scadenza, Integer codiceSeggio) {
		super();
		setCodice(codice);
		setScadenza(scadenza);
		setCodiceSeggio(codiceSeggio);
	}

	public Integer getCodice() {
		return codice;
	}

	public void setCodice(Integer codice) {
		this.codice = codice;
	}

	public Date getScadenza() {
		return scadenza;
	}

	public void setScadenza(Date scadenza) {
		this.scadenza = scadenza;
	}

	public Elettore getElettore() {
		return elettore;
	}

	public void setElettore(Elettore elettore) {
		this.elettore = elettore;
	}

	public Integer getCodiceSeggio() {
		return codiceSeggio;
	}

	public void setCodiceSeggio(Integer codiceSeggio) {
		this.codiceSeggio = codiceSeggio;
	}

	public Seggio getSeggio() {
		return seggio;
	}

	public void setSeggio(Seggio seggio) {
		this.seggio = seggio;
	}

	@Override
	public String toString() {
		return "Scheda [codice=" + codice + ", scadenza=" + scadenza + ", elettore=" + elettore + ", seggio=" + seggio
				+ "]";
	}

}
