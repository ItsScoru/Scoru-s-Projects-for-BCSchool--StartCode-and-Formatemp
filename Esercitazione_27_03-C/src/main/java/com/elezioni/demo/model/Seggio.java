package com.elezioni.demo.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Seggio implements Serializable{
	
	@Id
	@GeneratedValue
	private Integer codice;
	
	@Embedded
	private Ubicazione ubicazione;
	
	@Column(name = "data_votazione")
	@Temporal(TemporalType.DATE)
	private Date dataVoto;
	
	private Scheda scheda;

	public Seggio() {
		super();
	}

	public Seggio(Integer codice, Ubicazione ubicazione, Date dataVoto) {
		super();
		setCodice(codice);
		setUbicazione(ubicazione);
		setDataVoto(dataVoto);
	}

	public Integer getCodice() {
		return codice;
	}

	public void setCodice(Integer codice) {
		this.codice = codice;
	}

	public Ubicazione getUbicazione() {
		return ubicazione;
	}

	public void setUbicazione(Ubicazione ubicazione) {
		this.ubicazione = ubicazione;
	}

	public Date getDataVoto() {
		return dataVoto;
	}

	public void setDataVoto(Date dataVoto) {
		this.dataVoto = dataVoto;
	}

	public Scheda getScheda() {
		return scheda;
	}

	public void setScheda(Scheda scheda) {
		this.scheda = scheda;
	}

	@Override
	public String toString() {
		return "Seggio [codice=" + codice + ", ubicazione=" + ubicazione + ", dataVoto=" + dataVoto + "]";
	}

}
